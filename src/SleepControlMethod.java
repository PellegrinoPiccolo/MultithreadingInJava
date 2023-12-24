/**
 * The type Sleep control method.
 */
public class SleepControlMethod extends Thread{
    /**
     * Instantiates a new Sleep control method.
     *
     * @param name the name
     */
    public SleepControlMethod(String name) {
        super(name);
    }

    /**
     * Override Run method.
     */
    @Override
    public void run() {
        for(int i = 0;i < 10;i++){
            System.out.println((i+1) + " Thread: " + getName());
        }
        try{
            sleep(1000); //Blocks the execution of a thread for the specified time
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done! " + getName());
    }

    /**
     * The main for execution test of threads.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SleepControlMethod thread = new SleepControlMethod("T1");
        SleepControlMethod thread2 = new SleepControlMethod("T2");
        thread.start();
        thread2.start();
    }
}
