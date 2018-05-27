package nettystudy.aio;/**
 * Created by hasee on 2018/5/27.
 */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * @author zhaoyi
 * @createTime 2018-05-2018/5/27-17:58
 */
public class ReadCompletionHandler implements CompletionHandler<Integer,ByteBuffer> {
    private AsynchronousSocketChannel asynchronousSocketChannel;

    public ReadCompletionHandler(AsynchronousSocketChannel asynchronousSocketChannel) {
        if(this.asynchronousSocketChannel==null)
            this.asynchronousSocketChannel=asynchronousSocketChannel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body=new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String req=new String(body,"utf-8");
            System.out.println("the time server receive order= " + req);
            String currentTime="QUERY TIME ORDER".equalsIgnoreCase(req)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
            doWrite(currentTime);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String currentTime){
        if(currentTime!=null&&currentTime.length()>0){
            byte[] bytes=currentTime.getBytes();
            final ByteBuffer writeBuffer=ByteBuffer.allocate(currentTime.length());
            writeBuffer.put(bytes);
            writeBuffer.flip();
            asynchronousSocketChannel.write(writeBuffer,writeBuffer,new CompletionHandler<Integer,ByteBuffer>(){

                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if(writeBuffer.hasRemaining())
                        asynchronousSocketChannel.write(writeBuffer,writeBuffer,this);
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        asynchronousSocketChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });


        }

    }


    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.asynchronousSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
