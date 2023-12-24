/**
 * The type Join control methods.
 */
public class JoinControlMethods extends Thread{
    /**
     * Instantiates a new Join control methods.
     *
     * @param name the name
     */
    public JoinControlMethods(String name) {
        super(name);
    }

    /**
     * Override Run method.
     */
    @Override
    public void run() {
        for(int i = 0;i < 10;i++){
            System.out.println((i+1) + "Thread: " + this.getName());
        }
        System.out.println("Done! " + this.getName());
    }

    /**
     * Execution test for Join control method.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        JoinControlMethods thread = new JoinControlMethods("T1");
        JoinControlMethods thread2 = new JoinControlMethods("T2");
        thread.start();
        try {
            thread.join(); //Wait for the first thread to finish executing before starting the second thread
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread2.start();
    }
}
