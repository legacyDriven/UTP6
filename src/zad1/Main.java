/**
 *
 *  @author Śnieżko Eugeniusz S23951
 *
 */

package zad1;


public class Main {

  public static void main(String[] args) throws InterruptedException {
    Letters letters = new Letters("ABCD");
    for (Thread t : letters.getThreadNames()) System.out.println(t.getName());

    for(Thread t : letters.getThreadNames()){
      t.start();
    }

    try {
      Thread.sleep(5000);
    } catch (InterruptedException ex) {
      ex.printStackTrace();}

    letters.killAllThreads();

    System.out.println("\nProgram skończył działanie");
  }

}
