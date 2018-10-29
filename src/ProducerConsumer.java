import java.util.ArrayDeque;
import java.util.Queue;

class MyBlockingQueue<E>{
    private Queue<E> queue=null;
    private int limit;
    public MyBlockingQueue(int limit){
        this.limit=limit;
        queue=new ArrayDeque<>(limit);
    }
    public synchronized void put(E e) throws InterruptedException{
        while (queue.size()==limit){
            wait();
        }
        queue.add(e);
        notifyAll();
    }
    public synchronized E take() throws InterruptedException{
        while (queue.isEmpty()){
            wait();
        }
        E e=queue.poll();
        notifyAll();
        return e;
    }
}
class Producer extends Thread{
    MyBlockingQueue<String> queue;
    public Producer(MyBlockingQueue queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        int num=0;
        try {
            while (true){
                String stack=String.valueOf(num);
                queue.put(stack);
                System.out.println("produce task: "+stack);
                num++;
                Thread.sleep((int)(Math.random()*100));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class Consumer extends Thread{
    MyBlockingQueue<String> queue;
    public Consumer(MyBlockingQueue<String> queue){
        this.queue=queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                String task=queue.take();
                System.out.println("handle task: "+task);
                Thread.sleep((int)(Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ProducerConsumer {
    public static void main(String[] args) {
        MyBlockingQueue<String> queue=new MyBlockingQueue<>(10);
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}
