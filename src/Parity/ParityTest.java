package Parity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class ParityTest {

    public static byte[] fileToByteArray(String inputFile) throws Exception{
        byte [] fileContent=null;
        FileInputStream fis = new FileInputStream(inputFile);
        fileContent = new byte[(int)inputFile.length()];
        Path path = Paths.get(inputFile);
        fileContent= Files.readAllBytes(path);
        fis.close();
        return fileContent;
    }

    public static void byteArrayToFile(byte[] bFile, String fileDest) throws Exception {
        FileOutputStream fileOutputStream;
        fileOutputStream = new FileOutputStream(fileDest);
        fileOutputStream.write(bFile);

        fileOutputStream.close();

    }
    public static byte[] sameXOR(byte[] b1, byte[] b2) {
        // both arrays are of the same size
        byte[] parityByte = new byte[b1.length];

        for(int i=0;i<b1.length;i++) {
            parityByte[i]=(byte) (b1[i] ^ b2[i]);

        }


        return parityByte;
    }

    public static void main(String[] args) throws Exception{

// recovery part needs to be automated

        String f1= "/Users/shailendralohia/Desktop/FParity.txt";
        String f2 = "/Users/shailendralohia/Desktop/SParity.txt";
        String f3= "/Users/shailendralohia/Desktop/TParity.txt";

        // generate parity of f1 and f2

        byte[] parityB = sameXOR(fileToByteArray(f1),fileToByteArray(f2));
        byteArrayToFile(parityB,f3);


        //recover f1 after deleting it


    //byte[] parityB = sameXOR(fileToByteArray(f3),fileToByteArray(f2));
    //byteArrayToFile(parityB,f1);



        //recover f2 after deleting it
   /*
    byte[] parityB = XOR(fileToByteArray(f3),fileToByteArray(f1));
    byteArrayToFile(parityB,f2);
    */

        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to Delete and recover First File? (Yes/No)");

        String answer=sc.nextLine();

        if(answer.equalsIgnoreCase("yes")) {
            File file = new File("/Users/shailendralohia/Desktop/FParity.txt");
            if(file.delete()) {
                System.out.println("First File Deleted");
                byte[] parityC = sameXOR(fileToByteArray(f3), fileToByteArray(f2));
                byteArrayToFile(parityC, f1);
                if(parityC.length==fileToByteArray(f3).length &&
                        parityC.length==fileToByteArray(f2).length) {
                    System.out.println("First File has been recovered and has equal length");

                }
            }
        }
        System.out.println("Do you want to Delete and recover Second File? (Yes/No)");
        answer=sc.next();
        if(answer.equalsIgnoreCase("YES")) {
            File file = new File("/Users/shailendralohia/Desktop/SParity.txt");
            if(file.delete()) {
                System.out.println("Second File Deleted");
                byte[] parityD = sameXOR(fileToByteArray(f3), fileToByteArray(f1));
                byteArrayToFile(parityD, f2);
                if(parityD.length==fileToByteArray(f3).length &&
                        parityD.length==fileToByteArray(f1).length) {
                    System.out.println("Second File has been recovered and has equal length");

                }
            }
        }
        System.out.println("Do you want to Delete and recover Parity File? (Yes/No)");
        answer=sc.next();
        if(answer.equalsIgnoreCase("YES")) {
            File file = new File("/Users/shailendralohia/Desktop/TParity.txt");
            if(file.delete()) {
                System.out.println("Parity File Deleted");
                byte[] parityE = sameXOR(fileToByteArray(f1), fileToByteArray(f2));
                byteArrayToFile(parityE, f3);
                if(parityE.length==fileToByteArray(f2).length &&
                        parityE.length==fileToByteArray(f1).length) {

                }
            }
        }
    }
}
