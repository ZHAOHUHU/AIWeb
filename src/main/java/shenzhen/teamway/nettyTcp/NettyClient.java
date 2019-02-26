package shenzhen.teamway.nettyTcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import shenzhen.teamway.protocol.MessageDecode;
import shenzhen.teamway.protocol.MessageEncode;

/**
 * @program: ftpfolderweb
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-25 10:16
 **/
@Component
public class NettyClient {
    Logger log = LoggerFactory.getLogger(NettyClient.class);
    private EventLoopGroup group;
    private Channel channel = null;
    Bootstrap strap = null;

    public void connect(final String ip, final int port) {

        log.info("开始连接平台:" + ip + ':' + port);

        group = new NioEventLoopGroup();
        try {
            strap = new Bootstrap();
            strap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            log.info("连接通道建立。");
                            ChannelPipeline pieple = socketChannel.pipeline();
                            //添加解码类型
                            pieple.addLast(new MessageDecode());
                            //对所有从客户端发送的消息都进行编码
                            pieple.addLast(new MessageEncode());
                            pieple.addLast("handler", new NettyClientSSLHandler());

                        }
                    });

            // channel = strap.connect(ip, port).sync().channel();

            //同步变成异步操作不等待直接返回一个channelFuture，然后触发linster
            final ChannelFuture future = strap.connect(ip, port);

            //客户端启动的时候自动重连
            future.addListener(new ConnectionLinster());
            channel = future.awaitUninterruptibly().channel();

        } catch (Exception e) {
            e.printStackTrace();
            group.shutdownGracefully();
        } finally {

        }
        log.info("连接平台[" + ip + ':' + port + "]完成");
    }

}