package shenzhen.teamway.nettyTcp;

import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shenzhen.teamway.model.ResultInfo;
import shenzhen.teamway.protocol.Message;
import shenzhen.teamway.service.ResultInfoService;
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
                final ResultInfo resultInfo = new ResultInfo();
                resultInfo.setTaskType(2);
                resultInfo.setPicturePath(poll.getAbsolutePath());
                // resultInfoService.insertIntoResult(resultInfo);
                // final int id = resultInfoService.getId();
                final int id = 3;
                final byte[] image2byte = OtherUtiis.image2byte(poll);
                int i = image2byte.length;
                byte a = 1;
                byte b = 10;
                //  final Message message = new Message(a, b, 1, 26 + i, id + 1, i, image2byte);
                final Message message = new Message(a, b, 1, 26 + i, id + 1, 0, 0, i, image2byte);
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