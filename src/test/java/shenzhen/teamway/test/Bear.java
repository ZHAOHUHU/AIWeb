package shenzhen.teamway.test;

import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;
import shenzhen.teamway.service.imp.ResultInfoImp;
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
@Component
public class Bear {


    public static void main(String[] args) {
        new ResultInfoImp().getId();
    }
}