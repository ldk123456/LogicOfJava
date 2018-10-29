import java.util.concurrent.*;

public class MyThreadPool {
    private static int corePoolSize=10;
    private static int maxPoolSize=100;
    private static long  keepAliveTime=1000;
    private static BlockingQueue<Runnable> workQueue=new ArrayBlockingQueue<>(10);
    private static ThreadFactory threadFactory=Executors.defaultThreadFactory();
    private static RejectedExecutionHandler handler=new ThreadPoolExecutor.AbortPolicy();

    public static void main(String[] args) {
        ThreadPoolExecutor myExecutor=new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                keepAliveTime, TimeUnit.MILLISECONDS, workQueue, threadFactory, handler);
        myExecutor.execute(() -> System.out.println("自定义线程池"));
    }
}
