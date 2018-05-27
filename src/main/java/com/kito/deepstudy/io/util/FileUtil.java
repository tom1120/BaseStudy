package com.kito.deepstudy.io.util;/**
 * Created by hasee on 2017/6/25.
 */

import java.io.Closeable;
import java.io.IOException;

/**
 * @author zhaoyi
 * @createTime 2017-06-2017/6/25-16:11
 */
public class FileUtil {
    /**
     * 可变参数，只能放到形参的最后面，使用方法与数组一致
     * @param io
     */
    public static void close(Closeable ... io){
        for (Closeable temp:io
             ) {
            try {
                if(temp!=null){
                    temp.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(temp!=null){
                    try {
                        temp.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 泛型实现
     * @param io
     * @param <T>
     */
    public static <T extends Closeable> void closeAll(T ... io){
        close(io);
    }



}
