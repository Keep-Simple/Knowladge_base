package basics.BaseCourse.Concurrency._6;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static basics.BaseCourse.Concurrency._4.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    /**
     * Demonstrating the usage of ArrayBlockingQueue
     * Its fifo, and thread-safe
     * Replacing List<> with it, to let it handle sync
     */
    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(ThreadColor.ANSI_CYAN, buffer);
        MyConsumer consumer1 = new MyConsumer(ThreadColor.ANSI_BLUE, buffer);
        MyConsumer consumer2 = new MyConsumer(ThreadColor.ANSI_PURPLE, buffer);

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
    private ArrayBlockingQueue<String> buffer;

    public MyProducer(String color, ArrayBlockingQueue<String> buffer) {
        this.color = color;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);

                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {

        }
    }
}

class MyConsumer implements Runnable {
    private String color;
    private ArrayBlockingQueue<String> buffer;

    public MyConsumer(String color, ArrayBlockingQueue<String> buffer) {
        this.color = color;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            //adding sync, even that ArrayBlocking is thread-safe
            //because our run method isn't sync, so its possible
            //that buffer wasn't empty, 1 consumer thread suspended
            //and 2 consumer took that last element, so peek will return null!
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed" + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
