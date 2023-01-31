package sorts;

/**
 * FileName: ThreadTest
 * author: gxs
 * Date: 2021/12/1  18:36
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interruted");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Interruted when sleep");
                        //设置中断状态
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
