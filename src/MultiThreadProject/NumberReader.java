package MultiThreadProject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Shailendra on 12/4/2016.
 */
public class NumberReader {
    private FileReader _reader;
    private BufferedReader br = null;
    private List<Integer> readList;

    public NumberReader(File file) {
        try {
            br = new BufferedReader(new FileReader(file));
        }catch(IOException ioException ) {
            ioException.printStackTrace();
        }
        finally {
            try {

                if (br != null)
                    br.close();

                if (_reader != null)
                    _reader.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

    }

    public List<Integer> ReadIntegers() {
        String line;
        try {
            while ((line = br.readLine()) != null) {
                int value = Integer.parseInt(line);
                readList.add(value);
            }
            //Stream<String> lines = Files.lines();

        }catch(IOException e) {

            e.printStackTrace();

        }
        return readList;

    }
}
