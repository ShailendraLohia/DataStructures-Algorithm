package Lambda;

/**
 * Created by Shailendra on 11/25/2016.
 */
public class RunnableLamda {

    public static void main(String[] args) {

        Thread myThread = new Thread(() -> System.out.print("Hello Buddy, I have created runnable Lambda"));
        myThread.run();
        myThread.start();
    }
}
