import java.util.Timer;
import java.util.TimerTask;

public class BasicTimer {
    static class DelayTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("delayed task");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer=new Timer();
        DelayTask delayTask=new DelayTask();
        timer.schedule(delayTask, 1000);
        Thread.sleep(2000);
        timer.cancel();
    }
}
