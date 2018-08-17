package nettystudy.nettysample;/**
 * Created by hasee on 2018/8/17.
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * @author zhaoyi
 * @createTime 2018-08-2018/8/17-22:54
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
    private static final Logger logger= Logger.getLogger(TimeClientHandler.class.getName());
    private final ByteBuf firstMessage;

    public TimeClientHandler() {
        byte[] req="QUERY TIME ORDER".getBytes();
        firstMessage= Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf= (ByteBuf) msg;
        byte[] req=new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        String body=new String(req,"UTF-8");
        System.out.println("now is: = " + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warning("unexpected exception from downstream:"+cause.getMessage());
        ctx.close();

    }
}
