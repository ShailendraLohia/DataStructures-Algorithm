package Lambda;

/**
 * Created by Shailendra on 11/27/2016.
 */
public class MethodReference {
    public static void main(String[] args) {
        Thread thread = new Thread(MethodReference :: printMessage);
        Thread anotherThread = new Thread(() -> System.out.println("Another Lambda example"));
        thread.start();
        anotherThread.run();
    }

    public static void printMessage() {
        System.out.println("Hello");
    }
}
