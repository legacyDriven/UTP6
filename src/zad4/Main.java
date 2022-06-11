/**
 *
 *  @author Śnieżko Eugeniusz S23951
 *
 */

package zad4;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    BlockingQueue<Product> dataSource = new LinkedBlockingDeque<>();

    Thread prod = new Thread(new PublisherThread(200, -1, "Towary.txt", dataSource));
    Thread cons = new Thread(new ConsumerThread(dataSource, -1, 100));
    prod.start();
    cons.start();
  }
}
