package com.kito.thread.base;/**
 * Created by hasee on 2016/11/22.
 */

import java.util.concurrent.Callable;

/**
 * @author zhaoyi
 * @createTime 2016-11-2016/11/22-22:25
 */
public class CallableInterface implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        return 1;
    }
}
