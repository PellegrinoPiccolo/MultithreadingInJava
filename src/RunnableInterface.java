/**
 * The type Runnable interface.
 */
public class RunnableInterface implements Runnable{
    /**
     * The Name of thread.
     */
    private final String nameOfThread;

    /**
     * Instantiates a new Runnable interface.
     *
     * @param name the name
     */
    public RunnableInterface(String name){
        this.nameOfThread = name;
    }

    /**
     * Override Run method.
     */
    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            System.out.println((i+1) + " Thread: " + nameOfThread);
        }
    }

    /**
     * Main for execution of threads.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        RunnableInterface e = new RunnableInterface("Italy");
        Thread thread = new Thread(e);
        thread.start();
        RunnableInterface f = new RunnableInterface("United States");
        Thread SecondThread = new Thread(f);
        SecondThread.start();
    }
}
