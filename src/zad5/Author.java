/**
 *
 *  @author Śnieżko Eugeniusz S23951
 *
 */

package zad5;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class Author implements Runnable {

    public final List<String> arguments;

    private final AtomicBoolean isRunning;

    private final BlockingQueue<String> queue;

    private final String poisonPill;

    public Author(String[] args) {
        this.arguments = Arrays.asList(args);
        this.queue = new LinkedBlockingDeque<>(10);
        this.isRunning = new AtomicBoolean(false);
        this.poisonPill = "AveSatan";
    }

    @Override
    public void run() {
        isRunning.set(true);
        if (arguments.isEmpty()) {
            isRunning.set(false);
        }else{
            for (String s : arguments) {
                try {
                    queue.put(s);
                    Thread.sleep(1000);
                    if (arguments.indexOf(s) == arguments.size() - 1) queue.put(poisonPill);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public BlockingQueue<String> getQueue() {
        return queue;
    }

    public String getPoisonPill() {
        return poisonPill;
    }
}
