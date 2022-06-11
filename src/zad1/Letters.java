package zad1;

import java.util.ArrayList;
import java.util.List;

public class Letters {

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
            t.killThread();
        }
    }
}
