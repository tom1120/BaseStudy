package nettystudy.util;/**
 * Created by hasee on 2018/5/13.
 */

import java.io.Closeable;

/**
 * @author zhaoyi
 * @createTime 2018-05-2018/5/13-16:34
 */
public class StreamCloseUtil {

    public static void closeAllStreams(Closeable ... streams){
        for (Closeable s:streams
             ) {
            if(streams!=null){
                streams.clone();
            }
        }

    }

}
