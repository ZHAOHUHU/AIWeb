package shenzhen.teamway.test;

import io.netty.channel.ChannelHandlerContext;
import shenzhen.teamway.utils.FTPUtils;
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
 * @create: 2019-02-25 16:26
 **/
public class Bear {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    private Queue<File> img = new LinkedList<File>();
    String a = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "application.properties";
    final boolean b = PropertiesUtils.loadPropertiesFile(a);
    String path = PropertiesUtils.getValue("path");

    final Runnable runnable = new TimerTask() {
        @Override
        public void run() {
            execute(null,3);
        }
    };
    public void execute(ChannelHandlerContext ctx, int type) {
                    System.out.println("delay 3 seconds");
                    final List<File> files = FTPUtils.getFiles(path);
                    final List<File> fileSortName = FTPUtils.getFileSort(files);
                    for (File file : fileSortName) {
                        img.offer(file);
                    }
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new  Bear().runnable, 10, 2, TimeUnit.SECONDS);
    }
}