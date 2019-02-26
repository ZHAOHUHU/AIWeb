
package shenzhen.teamway.nettyTcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shenzhen.teamway.protocol.Message;

/**
 * @program: NettyServer
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2018-08-27 10:07
 **/
@Component
public class NettyClientSSLHandler extends SimpleChannelInboundHandler<Message> {
    GetThread getThread;
    PullThread pullThread;

    //todo:从队列拿图片
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        pullThread = new PullThread();
        pullThread.runTimeTask();
        getThread = new GetThread(pullThread, ctx);
        getThread.execute();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Message m) throws Exception {
        System.out.println(m.toString());
        final byte[] messageBody = m.getMessageBody();
        final int taskId = m.getTaskId();
        //todo 把他俩存数据库
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {


    }

    public NettyClientSSLHandler() {
    }
}