package BaseCourse.Concurrency._1;

import static BaseCourse.Concurrency._1.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Thread from class implementing Runnable Interface");
    }
}
