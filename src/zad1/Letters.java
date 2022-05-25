package zad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Letters {

    private volatile boolean stopRequested;
    private final List<Letter> threadList;

    public Letters(String threadNames) {
        this.stopRequested = false;
        List<String> threads = Arrays.asList(threadNames.split(""));
        threadList = new ArrayList<>();
        for(String s : threads){
            threadList.add(new Letter(s));
        }
    }

    public List<Letter> getThreadNames() {
        return threadList;
    }

    public void killAllThreads(){
        stopRequested = true;
    }

    private class Letter extends Thread{

        private final String letter;

        public Letter(String name) {
            super("Thread " + name);
            this.letter = name;
        }

        public void run() {
            while (!stopRequested) {
                System.out.print(letter);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
