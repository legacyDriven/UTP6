package zad4;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class PublisherThread implements Runnable {

    private final int repsBeforeLog;

    private final Product poisonPill;

    private final String pathToReadFrom;

    public BlockingQueue<Product> source;

    public PublisherThread(int repsBeforeLog, Integer poisonPillValues, String pathToReadFrom, BlockingQueue<Product> source) {
        this.repsBeforeLog = repsBeforeLog;
        this.poisonPill = new Product(poisonPillValues, poisonPillValues);
        this.pathToReadFrom = pathToReadFrom;
        this.source = source;
    }

    @Override
    public void run() {
        int counter = 0;
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(pathToReadFrom))) {
            while ((line = br.readLine()) != null) {
                source.put(Product.parseFromString(line));
                counter++;
                if(counter%repsBeforeLog==0){
                    System.out.println("utworzono " + counter + " obiektów");
                }
            }
            source.put(poisonPill);
        } catch (IOException e) {
            System.out.println("IOException in try block =>" + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

