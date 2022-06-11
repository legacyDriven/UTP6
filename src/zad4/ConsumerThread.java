package zad4;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerThread implements Runnable {

    private final AtomicInteger result;

    private final BlockingQueue <Product> source;

    private final Product poisonPill;

    private final AtomicBoolean isRunning;

    private int repsBeforeLog;

    public ConsumerThread(BlockingQueue<Product> source, int poisonPillValues, int repsBeforeLog) {
        this.repsBeforeLog = repsBeforeLog;
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
                if(counter%repsBeforeLog==0) System.out.println("policzono wage " + counter + " towarow");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumerThread that = (ConsumerThread) o;
        return Objects.equals(result, that.result) && Objects.equals(source, that.source) && Objects.equals(poisonPill, that.poisonPill) && Objects.equals(isRunning, that.isRunning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, source, poisonPill, isRunning);
    }
}
