package nettystudy.nio;/**
 * Created by hasee on 2018/5/13.
 */

/**
 * @author zhaoyi
 * @createTime 2018-05-2018/5/13-22:53
 */
public class TimeServer {
    public static void main(String[] args) {
        int port=8080;
        MultiplexerTimeServer multiplexerTimeServer=new MultiplexerTimeServer(port);
        new Thread(multiplexerTimeServer,"NIO-multiplexerTimeServer-001").start();
    }
}
