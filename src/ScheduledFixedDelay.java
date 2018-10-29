
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledFixedDelay {
    static class LongRunningTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("long running finished");
        }
    }
    static class FixedDelayTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService timer=Executors.newScheduledThreadPool(10);
        LongRunningTask longRunningTask=new LongRunningTask();
        FixedDelayTask fixedDelayTask=new FixedDelayTask();
        timer.schedule(longRunningTask, 10, TimeUnit.MILLISECONDS);
        timer.scheduleWithFixedDelay(fixedDelayTask, 100, 1000, TimeUnit.MILLISECONDS);
    }
}
