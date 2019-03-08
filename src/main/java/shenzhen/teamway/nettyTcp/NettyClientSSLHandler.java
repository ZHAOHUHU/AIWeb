
package shenzhen.teamway.nettyTcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shenzhen.teamway.jsonResult.FaceResult;
import shenzhen.teamway.model.Facedelect;
import shenzhen.teamway.protocol.Message;
import shenzhen.teamway.protocol.MessageType;
import shenzhen.teamway.service.ResultInfoService;

/**
 * @program: NettyServer
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2018-08-27 10:07
 **/
@Component
public class NettyClientSSLHandler extends SimpleChannelInboundHandler<Message> {
    @Autowired
    private ResultInfoService resultInfoService;
    Logger log = LoggerFactory.getLogger(NettyClientSSLHandler.class);
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
        FaceResult result = null;
        String s = null;
        final int requestType = m.getRequestType();
        if (requestType == MessageType.heartbeat) {
            log.info("收到心跳");
            ctx.channel().writeAndFlush(new Message(a, b, MessageType.heartbeat, 10, 0, 0, new byte[0]));
        }
        //判断
        else {
            final Facedelect f = new Facedelect();
            final byte[] messageBody = m.getMessageBody();
            final int taskId = m.getTaskId();
            if (messageBody.length != 0) {
                log.info("收到的图片id是" + taskId + "收到的消息结果是" + s);
                s = new String(messageBody, "utf-8");
            } else {
                log.error("收到的图片id是" + taskId + "模型解析不存在");
            }
            f.setResult(s);
            f.setId(taskId);
            final int countById = resultInfoService.getCountById(taskId);
            if (countById != 1) {
                log.error("根据id查询的结果不存在或者不唯一");
            } else {
                final int i = resultInfoService.updateResult(f);
                log.info("成功更新了" + i + "条数据");
            }

            log.debug("收到的图片id是" + taskId + "收到的消息结果是" + s);


        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.error("连接断开");
        if (pullThread != null && pullThread.service != null) {
            pullThread.service.shutdown();
            log.info("pullThread线程终止");
        }
        if (getThread != null && getThread.fixedThreadPool != null) {
            getThread.fixedThreadPool.shutdown();
            log.info("getThread线程终止");
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {


    }

    public NettyClientSSLHandler() {
    }
}