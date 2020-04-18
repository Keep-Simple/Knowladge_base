package BaseCourse.Concurrency._1;

import static BaseCourse.Concurrency._1.ThreadColor.ANSI_CYAN;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_CYAN + "Another Thread");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_CYAN + "Another thread woke me up");
            return;
        }
        System.out.println(ANSI_CYAN + "Another Thread is awaken after 3sec");
    }
}
