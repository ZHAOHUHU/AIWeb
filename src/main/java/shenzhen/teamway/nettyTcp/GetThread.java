package shenzhen.teamway.nettyTcp;

import io.netty.channel.ChannelHandlerContext;
import org.slf4j.LoggerFactory;
import shenzhen.teamway.model.Facedelect;
import shenzhen.teamway.protocol.Message;
import shenzhen.teamway.protocol.MessageType;
import shenzhen.teamway.service.imp.ResultInfoImp;
import shenzhen.teamway.utils.ApplicationContextProviderUtils;
import shenzhen.teamway.utils.OtherUtiis;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-25 16:15
 **/
//@Component
public class GetThread {
    static org.slf4j.Logger log = LoggerFactory.getLogger(GetThread.class);
    ResultInfoImp resultInfoService = ApplicationContextProviderUtils.getBean(ResultInfoImp.class);
    private PullThread pull;
    private ChannelHandlerContext ctx;
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);


    public GetThread(PullThread pull, ChannelHandlerContext ctx) {
        this.pull = pull;
        this.ctx = ctx;
    }

    public GetThread() {
    }

    public void execute() {
        fixedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                getFile();
            }
        });
    }

    public void getFile() {
        final Queue<File> imgs = pull.getImg();
        while (true) {
            if (imgs.size() != 0) {
                final File poll = imgs.poll();
                //向数据库添加图片路径
                final Facedelect f = new Facedelect();
                f.setFilepath(poll.getAbsolutePath());
                final int face = resultInfoService.insertFace(f);
                if (face > 0) {
                    log.info("插入数据库的条数成功+" + face + "条");
                } else {
                    log.error("插入数据库失败");
                }
                final int id = resultInfoService.getId();
                final byte[] image2byte = OtherUtiis.image2byte(poll);
                int i = image2byte.length;
                byte a = 1;
                byte b = 10;
                final Message message = new Message(a, b, MessageType.faceRequest, 18 + i, id , i, image2byte);
                ctx.channel().writeAndFlush(message);
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}