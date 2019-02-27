package shenzhen.teamway.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.LoggerFactory;
import shenzhen.teamway.utils.OtherUtiis;

import java.util.List;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-25 08:33
 **/
public class MessageDecode extends ByteToMessageDecoder {
    private static final int mixByte = 10;
    static org.slf4j.Logger log = LoggerFactory.getLogger(MessageDecode.class);


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {
        int taskId = 0;
        int bodylen = 0;
        byte[] temp = new byte[0];
        if (in.readableBytes() < mixByte) {
            log.error("字节长度不够");
        } else {

            final byte[] b = new byte[4];


            final byte head = in.readByte();
            final byte headLngth = in.readByte();
            in.readBytes(b);
            final int type = OtherUtiis.bytesToIntBig(b);
            in.readBytes(b);
            final int totalLngth = OtherUtiis.bytesToIntBig(b);
            if (type == MessageType.heartbeat) {
                Message message = new Message(head, headLngth, type, totalLngth, taskId, bodylen, temp);
            } else {
                in.readBytes(b);
                taskId = OtherUtiis.bytesToIntBig(b);
                in.readBytes(b);
                bodylen = OtherUtiis.bytesToIntBig(b);
                temp = new byte[bodylen];
                in.readBytes(temp);
            }
            Message message = new Message(head, headLngth, type, totalLngth, taskId, bodylen, temp);
            list.add(message);
        }
    }
}