/**
 *
 * @author Dilsi
 */
public class WorkerThread implements Runnable {

    private String thread;

    public WorkerThread(String s){
        this.thread=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start the thread. Thread No :  "+thread);
        threadQueue();
        System.out.println(Thread.currentThread().getName()+" End the thread");
    }

    private void threadQueue() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.thread;
    }
}
