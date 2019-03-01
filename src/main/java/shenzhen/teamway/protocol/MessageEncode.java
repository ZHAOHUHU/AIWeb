package shenzhen.teamway.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import shenzhen.teamway.utils.OtherUtiis;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-25 14:08
 **/
public class MessageEncode extends MessageToByteEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message m, ByteBuf b) throws Exception {
        b.writeByte(m.getHead());
        b.writeByte(m.getHeadLength());
        b.writeBytes(OtherUtiis.toLH(m.getRequestType()));
        b.writeBytes(OtherUtiis.toLH(m.getTotalLength()));
        if (m.getRequestType() == MessageType.faceRequest) {
            b.writeBytes(OtherUtiis.toLH(m.getTaskId()));
            b.writeBytes(OtherUtiis.toLH(m.getBodyLength()));
            b.writeBytes(m.getMessageBody());
        }

    }
}