import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InputParser {
    List<String> words;
    char[][] letters;

    void parse(String fileLocation) {
        File file = new File(fileLocation);
        String temp = file.getAbsolutePath();
        FileInputStream fis = null;
        BufferedReader reader;

        try{
            fis = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fis));

            String wordsLine = reader.readLine();
            words = Arrays.asList(wordsLine.split(","));

            String line = reader.readLine();
            ArrayList<String> letterLines = new ArrayList<>();
            while( line != null ){
                letterLines.add(line);

                line = reader.readLine();
            }

            if( letterLines.size() > 0 ){
                letters = new char[letterLines.size()][letterLines.get(0).split(",").length];

                for(int i=0; i < letterLines.size(); i++ ){
                    String[] letterLine = letterLines.get(i).split(",");
                    char[] letterRow = new char[letterLine.length];
                    for( int j=0; j < letterLine.length; j ++){
                        letterRow[j] = letterLine[j].charAt(0);
                    }

                    letters[i] = letterRow;
                }
            }
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
