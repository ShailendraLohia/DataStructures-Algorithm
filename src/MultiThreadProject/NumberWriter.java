package MultiThreadProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.util.List;

/**
 * Created by Shailendra on 12/4/2016.
 */
public class NumberWriter {
    private FileWriter _writer;
    private BufferedWriter bw = null;

    /*public NumberWriter(File file) {
        if(file.exists()) {
            file.delete();
        }
        try {
            bw = new BufferedWriter(new FileWriter(file));
        }catch(IOException ioException ) {
            ioException.printStackTrace();
        }
    }*/

    public void writeIntegers(List<Integer> values,File file) {
        if(file.exists()) {
            file.delete();
        }
        try {
        //_writer = new FileWriter(file);
            bw = new BufferedWriter(new FileWriter(file));
            //String line="Shailendra";
            //_writer.write("shailendra");
           // _writer.write(line);
        for(int value : values) {
            bw.write(Integer.toString(value));

            bw.newLine();
                //System.out.print("Writing");
            }

        }catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            try {
                if (bw != null)
                    bw.close();
                if (_writer != null)
                    _writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
