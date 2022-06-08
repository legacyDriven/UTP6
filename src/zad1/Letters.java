package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Letters {

    private final AtomicBoolean running = new AtomicBoolean(false);
    private final List<Letter> threadList;

    public Letters(String threadNames) {
        String[] threads = threadNames.split("");
        threadList = new ArrayList<>();
        for(String s : threads){
            threadList.add(new Letter(s));
        }
    }

    public List<Letter> getThreads() {
        return threadList;
    }

    public void killAllThreads(){
        for(Letter t : threadList){
            running.set(false);
            t.interrupt();
        }
    }

    private class Letter extends Thread{

        private final String letter;

        public Letter(String name) {
            super("Thread " + name);
            this.letter = name;
        }

        public void run() {
            running.set(true);
            while (running.get()) {
                try {
                    System.out.print(letter);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
