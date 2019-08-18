package MultiThreadProject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.File;

/**
 * Created by Shailendra on 12/4/2016.
 */
public class Calculator implements Runnable{
    private boolean isConsumer = false;
    private static boolean producerIsDone = false;

    static BlockingQueue<Integer> linesReadQueue = new ArrayBlockingQueue<Integer>(100000);
    private static final int CONSUMER_COUNT = 1;
    static List<Integer> results = new ArrayList<Integer>();

    public Calculator(boolean consumer) {
        this.isConsumer = consumer;
    }


    public void RunMethod() {

        long startTime = System.nanoTime();
        System.out.println("Start time: " + startTime);
        int processors = Runtime.getRuntime().availableProcessors(); // Available processor
        ExecutorService producerPool = Executors.newFixedThreadPool(1);
        //producerPool.submit(new Calculator(false)); // run method is called
        producerPool.execute(new Calculator(false));
        System.out.println("Producer Thread created ");

        // create a pool of consumer threads to parse the lines read
        System.out.println("Number Of Threads: " + processors*2);
        ExecutorService consumerPool = Executors.newFixedThreadPool(processors*2);
        for (int i = 0; i < processors*2; i++) {
            //consumerPool.submit(new Calculator(true)); // run method is called
            System.out.println("Inside  create Consumer Threads: ");
            consumerPool.execute(new Calculator(true));
        }

        producerPool.shutdown();
        consumerPool.shutdown();
        while (!producerPool.isTerminated() && !consumerPool.isTerminated()) {
        }

        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
        System.out.println(results.size() + " " + "of the numbers were prime");

    }

    private void readFile() {
        System.out.println("Producer Thread is reading file");
        Path file = Paths.get("shail.txt");
        try
        {
            //Java 8: Stream class
            Stream<String> lines = Files.lines( file );
            //Stream<String> lines = File.
            for( String line : (Iterable<String>) lines::iterator )
            {
                //System.out.println("read=" + line);
                int value = Integer.parseInt(line);
                System.out.println("Inside ReadFile method" + value);
                System.out.println("Blocking queue" + linesReadQueue.size());
                linesReadQueue.put(value); //blocked if reaches its capacity, until consumer consumes
                //System.out.println(Thread.currentThread().getName() + ":: producer count = "+  linesReadQueue.size());
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        producerIsDone = true; // signal consumer
        System.out.println(Thread.currentThread().getName() + " producer is done");
    }
    @Override
    public void run() {
        try {
            if (isConsumer) {
                Thread.sleep(2000);
                System.out.println("Inside Consumer run method");
                IsNumberPrimeCalculator primeCalculator = new IsNumberPrimeCalculator();
                consume(results, primeCalculator);
            } else {
                System.out.println("Inside Producer run method");
                readFile(); //produce data by reading a file
            }
        }catch(InterruptedException ex) {
            ex.printStackTrace();
            }
    }

    private void consume(List<Integer> results, IsNumberPrimeCalculator primeCalculator) {
        try {
            System.out.println("Size of queue, Inside consume: " + linesReadQueue.size());
            while (!linesReadQueue.isEmpty()) { // If queue is not empty
                //while (!producerIsDone || (producerIsDone && !linesReadQueue.isEmpty())) {
                int lineToProcess = linesReadQueue.take();
                System.out.println("Inside consume method " + lineToProcess);
                primeCalculator.CheckIfNumbersArePrime(lineToProcess,results); // some CPU intensive processing
                Thread.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Total prime numbers" + results.size());
        System.out.println(Thread.currentThread().getName() + " consumer is done");
    }
}
