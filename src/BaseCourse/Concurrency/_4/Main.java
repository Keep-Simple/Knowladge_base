package BaseCourse.Concurrency._4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static BaseCourse.Concurrency._4.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        MyProducer producer = new MyProducer(ThreadColor.ANSI_CYAN, buffer, bufferLock);
        MyConsumer consumer1 = new MyConsumer(ThreadColor.ANSI_BLUE, buffer, bufferLock);
        MyConsumer consumer2 = new MyConsumer(ThreadColor.ANSI_PURPLE, buffer, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}

class MyProducer implements Runnable {
    private String color;
    private List<String> buffer;
    private ReentrantLock bufferLock;

    public MyProducer(String color, List<String> buffer, ReentrantLock bufferLock) {
        this.color = color;
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            System.out.println(color + "Adding..." + num);
            bufferLock.lock();
            try {
                buffer.add(num);
            } finally {
                bufferLock.unlock();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyConsumer implements Runnable {
    private String color;
    private List<String> buffer;
    private ReentrantLock bufferLock;


    public MyConsumer(String color, List<String> buffer, ReentrantLock bufferLock) {
        this.color = color;
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true) {
            bufferLock.lock();
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed" + buffer.remove(0));
                }
            } finally {
                bufferLock.unlock();
            }
        }
    }
}
/**
 * Demonstrating tryLock()
 */
//    @Override
//    public void run() {
//        int count = 0;
//        while (true) {
//            if (bufferLock.tryLock()) {
//                try {
//                    if (buffer.isEmpty()) {
//                        continue;
//                    }
//                    System.out.println(count);
//                    count = 0;
//                    if (buffer.get(0).equals(EOF)) {
//                        System.out.println(color + "Exiting");
//                        break;
//                    } else {
//                        System.out.println(color + "Removed" + buffer.remove(0));
//                    }
//                } finally {
//                    bufferLock.unlock();
//                }
//            } else count++;
//        }
//    }


