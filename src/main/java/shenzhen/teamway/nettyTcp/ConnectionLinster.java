package shenzhen.teamway.nettyTcp;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @program: NettyServer
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2018-08-29 11:24
 **/
public class ConnectionLinster implements ChannelFutureListener {

    private NettyClient client = new NettyClient();
    Logger log = LoggerFactory.getLogger(ConnectionLinster.class);

    @Override
    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (!channelFuture.isSuccess()) {
            final EventLoop eventLoop = channelFuture.channel().eventLoop();
            eventLoop.schedule(new Runnable() {
                @Override
                public void run() {
                    log.info("开始重连平台。");
                    //todo:重连的  IP和端口号
                    client.connect("192.168.12.35",6666);
                   // 60秒重连一次
                }
            }, 60L, TimeUnit.SECONDS);
        }else{
            log.info("连接成功");
        }
    }


}