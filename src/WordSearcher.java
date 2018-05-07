import java.util.List;

class WordSearcher {

    String Search(List<String> words, char[][] letters){
        String word = words.get(0);
        String coordinates = "";

        for(int j = 0; j < letters[0].length; j ++ ){
            if(letters[0][j] == word.charAt(0) && letters[0][j+1] == word.charAt(1)) {
                coordinates = "(0," + j + "),(0," + (j+1) + ")";
                break;
            }
        }

        return word + ": " + coordinates;
    }
}
