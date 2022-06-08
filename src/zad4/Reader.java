package zad4;


public class Reader implements Runnable {


    @Override
    public void run() {

    }

}

/*
static volatile BigInteger value = new BigInteger("0");
    private String path;

    public Reader(String path) {
        this.path = path;
    }

    @Override
    public void run() {

    }

    public static synchronized BigInteger getValue(){
        return value;
    }

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();
        Runnable r = ()-> {
            while (true) {
                System.out.println(Reader.getValue());
            }
        };
        Thread thread = new Thread(r, "writer");
        thread.start();
        int i=0;
        while(true){
            list.add(3);
            Reader.value = Reader.value.add(new BigInteger("1"));

            if(i>1000){
                list = new ArrayList<>();
                i=0;
            }
            i++;
        }
    }
 */