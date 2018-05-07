import java.io.*;
import java.util.Arrays;
import java.util.List;

class InputParser {
    List<String> words;
    char[][] letters;

    void parse(String fileLocation) {
        File file = new File(fileLocation);
        FileInputStream fis = null;
        BufferedReader reader;

        try{
            fis = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fis));

            String wordsLine = reader.readLine();
            words = Arrays.asList(wordsLine.split(","));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
