package nettystudy.aio;/**
 * Created by hasee on 2018/5/27.
 */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhaoyi
 * @createTime 2018-05-2018/5/27-18:13
 */
public class AsyncTimeClientHandler implements CompletionHandler<Void,AsyncTimeClientHandler>,Runnable {

    private AsynchronousSocketChannel asynchronousSocketChannel;
    private String host;
    private int port;
    private CountDownLatch latch;

    public AsyncTimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            asynchronousSocketChannel=AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch=new CountDownLatch(1);
        asynchronousSocketChannel.connect(new InetSocketAddress(host,port),this,this);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            asynchronousSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        byte[] req="QUERY THE TIME".getBytes();
        final ByteBuffer writeBuffer=ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        asynchronousSocketChannel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if(writeBuffer.hasRemaining()){
                    asynchronousSocketChannel.write(writeBuffer,writeBuffer,this);
                }else {
                    final ByteBuffer readBuffer=ByteBuffer.allocate(1024);
                    asynchronousSocketChannel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            byte[] bytes=new byte[readBuffer.remaining()];
                            readBuffer.get(bytes);
                            String body;
                            try {
                                body=new String(bytes,"utf-8");
                                System.out.println("Now is:"+body);
                                latch.countDown();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                asynchronousSocketChannel.close();
                                latch.countDown();
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
                    asynchronousSocketChannel.close();
                    latch.countDown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
     }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        exc.printStackTrace();
        try {
            asynchronousSocketChannel.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
