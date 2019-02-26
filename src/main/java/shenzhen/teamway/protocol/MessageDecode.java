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
        log.debug("decode可以收到请求但是可说不准能解析");
        if (in.readableBytes() < mixByte) {
            log.error("字节长度不够");
        } else {
            final byte[] b = new byte[4];
            final byte head = in.readByte();
            final byte headLngth = in.readByte();
            //final int type = in.readInt();
            //final int totalLngth = in.readInt();
            //final int taskId = in.readInt();
            //final int width = in.readInt();
            //final int height = in.readInt();
            //final int bodylen = in.readInt();
            in.readBytes(b);
            final int type = OtherUtiis.bytesToIntBig(b);
            in.readBytes(b);
            final int totalLngth = OtherUtiis.bytesToIntBig(b);
            in.readBytes(b);
            final int taskId = OtherUtiis.bytesToIntBig(b);
            in.readBytes(b);
            final int width = OtherUtiis.bytesToIntBig(b);
            in.readBytes(b);
            final int height = OtherUtiis.bytesToIntBig(b);
            in.readBytes(b);
            final int bodylen = OtherUtiis.bytesToIntBig(b);
            final byte[] temp = new byte[bodylen];
            in.readBytes(temp);
            final Message message = new Message(head, headLngth, type, totalLngth, taskId, width, height, bodylen, temp);
            list.add(message);
        }
    }
}