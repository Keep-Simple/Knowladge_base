package BaseCourse.Concurrency._5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static BaseCourse.Concurrency._4.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    /**
     * Demonstrating the usage of ExecutorService class
     */
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(ThreadColor.ANSI_CYAN, buffer, bufferLock);
        MyConsumer consumer1 = new MyConsumer(ThreadColor.ANSI_BLUE, buffer, bufferLock);
        MyConsumer consumer2 = new MyConsumer(ThreadColor.ANSI_PURPLE, buffer, bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_RESET + "I'm being printed for the Callable");
                return ThreadColor.ANSI_RESET + "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println(ThreadColor.ANSI_RESET + "Something went wrong");
        } catch (InterruptedException e) {
            System.out.println(ThreadColor.ANSI_RESET + "Thread running the task was interrupted");
        }

        executorService.shutdown();
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
