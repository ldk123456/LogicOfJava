import java.util.Timer;
import java.util.TimerTask;

public class TimerFixedDelay {
    static class LongRunningTask extends TimerTask{
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
    static class FixedDelayTask extends TimerTask{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        Timer timer=new Timer();
        LongRunningTask longRunningTask=new LongRunningTask();
        FixedDelayTask fixedDelayTask=new FixedDelayTask();
        timer.schedule(longRunningTask, 10);
        timer.schedule(fixedDelayTask, 100, 1000);
    }
}
