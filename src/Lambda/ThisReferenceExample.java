package Lambda;

/**
 * Created by Shailendra on 11/27/2016.
 */
public class ThisReferenceExample {
    public void doProcess(int i, Process p) {
        p.process(i);
    }
    public  void execute() {
        doProcess(20,i -> {
            System.out.println("value of i is: " + i);
            System.out.println(this); //here this work becuse it doesn'thave static context.
        });
    }
    public String toString() {
        return "I am in ThisReferenceExample class";
    }
    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        thisReferenceExample.doProcess(10,i -> {
            System.out.println("value of i is: " + i);
            //System.out.println(this); this will not work with lambda.
        });
        thisReferenceExample.execute();
    }

}

interface Process {
    public void process(int i);
}
