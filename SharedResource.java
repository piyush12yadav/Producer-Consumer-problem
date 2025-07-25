import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize){
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception{

        // if buffer is full then wait for consumer to consume; 
        while(sharedBuffer.size() == bufferSize){
            System.out.println("Buffer is full Producer is waiting for Consumer");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("Produced ---"+ item);
        Thread.sleep(5000); // Simulate time to produce
        notify();
    }

    public synchronized int consume() throws Exception{
        // if buffer is empty then wait for Producer to Produce;
        while (sharedBuffer.isEmpty()) {
            System.out.println("Buffer is empty Consumer is waiting for Producer");
            wait();
        }

        int item = sharedBuffer.poll();
        System.out.println("Consumed item ---"+item);

        Thread.sleep(5000); // Simulate time to produce
        notify();
        return item;
    }
}
