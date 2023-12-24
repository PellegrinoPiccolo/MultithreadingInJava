/**
 * This class use for test implementation of thread with Thread Class
 */
public class ThreadClass extends Thread{
    /**
     * Instantiates a new Thread class.
     *
     * @param name the name
     */
    public ThreadClass(String name) {
        super(name);
    }

    /**
     * Override the run method of thread class
     */
    @Override
    public void run() {
        for(int i = 0; i < 10;i++){
            System.out.println((i+1) + " " + this.getName());
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("DONE! " + this.getName());
    }

    /**
     * Test thread execution
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ThreadClass FirstThread = new ThreadClass("Italy");
        FirstThread.start();
        ThreadClass SecondThread = new ThreadClass("Unites States");
        SecondThread.start();
    }
}
