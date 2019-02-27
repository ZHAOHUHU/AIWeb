
package shenzhen.teamway.nettyTcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shenzhen.teamway.jsonResult.FaceResult;
import shenzhen.teamway.model.Facedelect;
import shenzhen.teamway.protocol.Message;
import shenzhen.teamway.protocol.MessageType;
import shenzhen.teamway.utils.Json2Person;

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

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        pullThread = new PullThread();
        pullThread.runTimeTask();
        getThread = new GetThread(pullThread, ctx);
        getThread.execute();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Message m) throws Exception {
        byte a = 1;
        byte b = 10;
        System.out.println(m.toString());
        final int requestType = m.getRequestType();
        if (requestType == MessageType.heartbeat) {
            ctx.channel().writeAndFlush(new Message(a, b, MessageType.heartbeat, 10, 0, 0, new byte[0]));
        } else {
            final byte[] messageBody = m.getMessageBody();
            final int taskId = m.getTaskId();
            final String s = new String(messageBody);
            if (s.length()==2){

            }
            System.out.println("收到的消息结果是" + s);
            //todo:返回空集合怎么处理  识别不出来的人
            final FaceResult result = Json2Person.getResult(s);
            System.out.println(result.toString());
            //todo 把他俩存数据库

        }
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