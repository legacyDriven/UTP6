/**
 *
 *  @author Śnieżko Eugeniusz S23951
 *
 */

package zad5;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Writer implements Runnable {

    AtomicBoolean isRunning;

    private BlockingQueue <String> queue;

    private final String poisonPill;

    public Writer(Author author) {
        this.queue = author.getQueue();
        this.poisonPill = author.getPoisonPill();
        this.isRunning = new AtomicBoolean(false);
    }

    @Override
    public void run() {
        this.isRunning.set(true);
        String current = "";
        while(isRunning.get())
        try {
            current = queue.take();
            if(!current.equals(poisonPill)){
                System.out.println(current);
            } else {
                isRunning.set(false);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
