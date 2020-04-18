package BaseCourse.Concurrency._1;

import static BaseCourse.Concurrency._1.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_BLUE + "In main thread");

        //class that extends Thread
        Thread one = new AnotherThread();
        one.start();

        //anonymous class
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Anonymous class thread");
            }
        }.start();

        //class that implements Runnable, instance passed to Thread constructor
        Thread two = new Thread(new MyRunnable());
        two.start();

        //same as previous but passing anonymous class instead
        Thread three = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ANSI_PURPLE + "Passing anonymous class to Thread constructor");
                try {
                    one.join(1000);
                    System.out.println(ANSI_CYAN + "Thread one terminated or timed out, so back to third thread");
                } catch (InterruptedException e) {
                    System.out.println("Interrupted");
                }
            }
        });
        three.start();

        //Interrupting to get into catch block
//        one.interrupt();

        //back to main thread
        System.out.println(ANSI_BLUE + "Still in main");
    }
}
