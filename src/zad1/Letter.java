package zad1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Letter extends Thread{

    private final AtomicBoolean running = new AtomicBoolean(false);

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

    void killThread(){
        this.running.set(false);
    }
}