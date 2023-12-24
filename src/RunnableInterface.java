/**
 * The type Runnable interface.
 */
public class RunnableInterface implements Runnable{
    /**
     * Override Run method.
     */
    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            System.out.println((i+1) + " Thread: " + Thread.currentThread().getName());
        }
    }

    /**
     * Main for execution of threads.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        RunnableInterface e = new RunnableInterface();
        Thread thread = new Thread(e, "Italy");
        thread.start();
        RunnableInterface f = new RunnableInterface();
        Thread SecondThread = new Thread(f, "United States");
        SecondThread.start();
    }
}
