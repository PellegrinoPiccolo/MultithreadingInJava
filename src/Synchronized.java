/**
 * The type Synchronized.
 */
public class Synchronized implements Runnable{
    /**
     * The constant value.
     */
    private static int value = 50;

    /**
     * Get.
     */
    public synchronized void get(){
        while (value <= 0) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " in Wait");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        value -= 5;
        System.out.println("Value " + value + " subtracted from Thread: " + Thread.currentThread().getName());
        notify();
    }

    /**
     * Run.
     */
    @Override
    public void run() {
        get();
    }

    /**
     * Main for execute thread.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Synchronized(), "T1");
        Thread t2 = new Thread(new Synchronized(), "T2");
        t1.start();
        t2.start();
    }
}
