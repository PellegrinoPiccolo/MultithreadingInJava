public class SynchronizedWithLock implements Runnable{
    private static int value = 50;
    private static Object lock = new Object();
    public void get(){
        synchronized (lock){
            value -= 5;
            System.out.println("Subtracted value " + value + " from: " + Thread.currentThread().getName());
        }
    }
    @Override
    public void run() {
        get();
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new SynchronizedWithLock(), "T1");
        Thread t2 = new Thread(new SynchronizedWithLock(), "T2");
        t1.start();
        t2.start();
    }
}
