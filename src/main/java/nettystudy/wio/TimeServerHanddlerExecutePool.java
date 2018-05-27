package nettystudy.wio;/**
 * Created by hasee on 2018/5/13.
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyi
 * @createTime 2018-05-2018/5/13-17:12
 */
public class TimeServerHanddlerExecutePool {
    private ExecutorService executorService;

    public TimeServerHanddlerExecutePool(int macPoolSize,int queueSize) {
        executorService=new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),macPoolSize,120L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }
    public void execute(Runnable task){
        executorService.execute(task);
    }
}
