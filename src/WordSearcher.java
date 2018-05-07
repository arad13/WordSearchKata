import java.util.List;

class WordSearcher {

    String Search(List<String> words, char[][] letters){
        String word = words.get(0);
        StringBuilder coordinates = new StringBuilder();

        for(int j = 0; j < letters[0].length; j ++ ){
            if(letters[0][j] == word.charAt(0)){
                int incrementer = 1;
                boolean found = true;
                while( incrementer < word.length() && (j+incrementer) < letters[0].length ){
                    if( letters[0][(j+incrementer)] != word.charAt(incrementer) )
                        found = false;

                    incrementer ++;
                }

                if( found ) {
                    for( int k = 0; k < word.length(); k ++ ) {
                        coordinates.append("(0,").append(j + k).append(")");

                        if (k != word.length() - 1)
                            coordinates.append(",");
                    }
                    break;
                }
            }
        }

        return word + ": " + coordinates;
    }
}
