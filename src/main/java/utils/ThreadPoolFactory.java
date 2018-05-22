package utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wujin on 2017/2/15.
 */
public class ThreadPoolFactory {
    private static ThreadPoolFactory factory;
    //线程池
    private static ExecutorService fixedThreadPool;

    static{
        getSingleton();
    }

    public static ExecutorService getSingleton() {
        if (fixedThreadPool == null) { //Single Checked
            synchronized (ExecutorService.class) {//Double Checked
                if (fixedThreadPool == null) {
                    fixedThreadPool = Executors.newFixedThreadPool(500);
                }
            }
        }
        return fixedThreadPool;
    }
    /**
     * 创建线程池
     * */
    public static ThreadPoolFactory createPool (int num){
        if(factory==null){
            fixedThreadPool=Executors.newFixedThreadPool(num);
            factory=new ThreadPoolFactory();
        }
        return factory;
    }
    public static ThreadPoolFactory createPool (){
        if(factory==null){
            fixedThreadPool=Executors.newFixedThreadPool(5);
            factory=new ThreadPoolFactory();
        }
        return factory;
    }
    /**
     * 运行
     * */
    public static void doTask(Runnable runnable){
        fixedThreadPool.execute(runnable);
    }

}
