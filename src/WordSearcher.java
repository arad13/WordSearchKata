import java.util.List;

class WordSearcher {
    private String lineSeparator = System.getProperty("line.separator");

    String Search(List<String> words, char[][] letters){
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder coordinates = new StringBuilder();

            for( int i = 0; i < letters.length; i++ ) {
                for (int j = 0; j < letters[i].length; j++) {
                    if (letters[i][j] == word.charAt(0)) {
                        int incrementer = 1;
                        boolean found = true;
                        while (incrementer < word.length() && (j + incrementer) < letters[i].length) {
                            if (letters[i][(j + incrementer)] != word.charAt(incrementer))
                                found = false;

                            incrementer++;
                        }

                        if (found) {
                            for (int k = 0; k < word.length(); k++) {
                                coordinates.append("(").append(i).append(",").append(j + k).append(")");

                                if (k != word.length() - 1)
                                    coordinates.append(",");
                            }
                            break;
                        }
                    }
                }
            }

            if (!result.toString().equals(""))
                result.append(lineSeparator);
            result.append(word).append(": ").append(coordinates);
        }

        return result.toString();
    }
}
