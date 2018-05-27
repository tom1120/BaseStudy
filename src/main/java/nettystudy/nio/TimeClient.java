package nettystudy.nio;/**
 * Created by hasee on 2018/5/16.
 */

/**
 * @author zhaoyi
 * @createTime 2018-05-2018/5/16-0:04
 */
public class TimeClient {
    public static void main(String[] args) {
        new Thread(new TimeClientHandler("127.0.0.1",8080),"TimeClient_001").start();
    }
}
