package MultiThreadProject;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Shailendra on 12/4/2016.
 */
public class Program {
    static final int LowerBound = 1000000;
    static final int UpperBound = 5000000;
    public static void main(String[] args) {
        List<String> arguments = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        arguments.add(scan.next());
        arguments.add(scan.next());
        /*String firstScan = scan.next();
        String secondScan = scan.next();
        List<String> arguments = new ArrayList<String>();
        arguments.add(firstScan);
        arguments.add(secondScan);*/
        try {
            if (arguments.size() == 2) {
                File fileName = new File("shail.txt");
                if (arguments.get(0).equals("--createDataFile")) {
                    NumberWriter writer = new NumberWriter();
                    writer.writeIntegers(Sequence.Create(LowerBound, UpperBound),fileName);
                } else if (arguments.get(0).equals("--processDataFile")) {
                    //NumberReader reader = new NumberReader(fileName);
                    Calculator cal = new Calculator(false);
                    cal.RunMethod();
                }
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }


    }
}
