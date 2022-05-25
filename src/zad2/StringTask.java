package zad2;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class StringTask implements Runnable {

    private TaskState state;
    private final String argument;
    private String result;
    private final long repetitions;
    private Thread instanceThread;


    public StringTask(String argument, long repetitions) {
        this.state = TaskState.CREATED;
        this.argument = argument;
        this.repetitions = repetitions;
    }

    @Override
    public void run() {
        state = TaskState.RUNNING;
        int repetitionCounter = 0;
        while (repetitionCounter < repetitions && !instanceThread.isInterrupted()){
            result += argument;
            repetitionCounter++;
        }
        state = TaskState.READY;
    }

    public void start() {
        if (instanceThread == null) {
            instanceThread = new Thread(this, argument);
            instanceThread.start();
        }
    }

    public void abort() {
        state = TaskState.ABORTED;
        instanceThread.interrupt();
    }

    public TaskState getState() {
        return state;
    }

    public String getResult(){
        return result;
    }

    public boolean isDone(){
        return state == TaskState.READY || state == TaskState.ABORTED;
    }
}
