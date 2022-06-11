package zad4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerThread implements Runnable {

    private AtomicInteger result;

    private BlockingQueue <Product> source;

    private final Product poisonPill;

    private AtomicBoolean isRunning;

    public ConsumerThread(BlockingQueue<Product> source, int poisonPillValues) {
        this.isRunning = new AtomicBoolean(false);
        this.result = new AtomicInteger(0);
        this.source = source;
        this.poisonPill = new Product(poisonPillValues, poisonPillValues);
    }

    @Override
    public void run() {
        isRunning.set(true);
        int counter = 0;
        while(isRunning.get()){
            try {
                Product current = source.take();
                if(current.getWeight()<=0){
                    System.out.println("Sumaryczna waga dotychczas zsumowanych towarów w ilości: " + counter + " wynosi " + result.get());
                    return;
                } else { result.addAndGet(current.getWeight());
                    counter++;
                if(counter%100==0) System.out.println("policzono wage " + counter + " towarow");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
