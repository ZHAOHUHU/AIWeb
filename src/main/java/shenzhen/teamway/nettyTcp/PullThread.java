package shenzhen.teamway.nettyTcp;

import io.netty.channel.ChannelHandlerContext;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shenzhen.teamway.model.ResultInfo;
import shenzhen.teamway.protocol.Message;
import shenzhen.teamway.protocol.MessageDecode;
import shenzhen.teamway.service.ResultInfoService;
import shenzhen.teamway.utils.FTPUtils;
import shenzhen.teamway.utils.OtherUtiis;
import shenzhen.teamway.utils.PropertiesUtils;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-25 14:25
 **/
@Component
public class PullThread {
    static org.slf4j.Logger log = LoggerFactory.getLogger(PullThread.class);
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    private Queue<File> img = new LinkedList<File>();
    String a = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "application.properties";
    final boolean b = PropertiesUtils.loadPropertiesFile(a);
    String path = PropertiesUtils.getValue("path");

    /**
     * @Author: Zhao Hong Ning
     * @Description:向队列里添加file
     * @Date: 2019/2/25
     * @param: ctx
     * @param: type
     * @return: void
     */
    public void execute(ChannelHandlerContext ctx, int type) {
        System.out.println("xunhuan");
        final List<File> files = FTPUtils.getFiles(path);
        final List<File> fileSortName = FTPUtils.getFileSort(files);
        for (File file : fileSortName) {
            img.offer(file);
        }

    }

    public void runTimeTask() {
        service.scheduleAtFixedRate(runnable, 0, 3, TimeUnit.SECONDS);
    }

    final Runnable runnable = new TimerTask() {
        @Override
        public void run() {
            execute(null, 3);
        }
    };

    public Queue<File> getImg() {
        return img;
    }

    public void setImg(Queue<File> img) {
        this.img = img;
    }

    public PullThread() {
    }
}