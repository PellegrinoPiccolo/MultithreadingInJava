/**
 * The type Synchronized with lock.
 */
public class SynchronizedWithLock implements Runnable{
    /**
     * The constant value.
     */
    private static int value = 50;
    /**
     * The constant lock.
     */
    private static Object lock = new Object();

    /**
     * Get.
     */
    public void get(){
        synchronized (lock){
            value -= 5;
            System.out.println("Subtracted value " + value + " from: " + Thread.currentThread().getName());
        }
    }

    /**
     * Override Run method.
     */
    @Override
    public void run() {
        get();
    }

    /**
     * Main where execute threads.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new SynchronizedWithLock(), "T1");
        Thread t2 = new Thread(new SynchronizedWithLock(), "T2");
        t1.start();
        t2.start();
    }
}
