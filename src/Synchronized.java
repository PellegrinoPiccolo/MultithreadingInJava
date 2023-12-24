public class Synchronized implements Runnable{
    private static int value = 50;
    public synchronized void get(){
        while (value <= 0) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " in pausa");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        value -= 5;
        System.out.println("Valore sottratto dal Thread: " + Thread.currentThread().getName());
        notify();
    }
    @Override
    public void run() {
        get();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Synchronized(), "T1");
        Thread t2 = new Thread(new Synchronized(), "T2");
        t1.start();
        t2.start();
    }
}
