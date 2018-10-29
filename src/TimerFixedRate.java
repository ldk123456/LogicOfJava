import java.util.Timer;
import java.util.TimerTask;

public class TimerFixedRate {
    static class LongRunningTask extends TimerTask {
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
    static class FixedRateTask extends TimerTask{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        Timer timer=new Timer();
        LongRunningTask longRunningTask=new LongRunningTask();
        FixedRateTask fixedDelayTask=new FixedRateTask();
        timer.schedule(longRunningTask, 10);
        timer.scheduleAtFixedRate(fixedDelayTask, 100, 1000);
    }
}
