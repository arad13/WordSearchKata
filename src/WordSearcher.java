import java.util.List;

class WordSearcher {
    private String lineSeparator = System.getProperty("line.separator");

    String Search(List<String> words, char[][] letters){
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder coordinates = new StringBuilder();

            for (int j = 0; j < letters[0].length; j++) {
                if (letters[0][j] == word.charAt(0)) {
                    int incrementer = 1;
                    boolean found = true;
                    while (incrementer < word.length() && (j + incrementer) < letters[0].length) {
                        if (letters[0][(j + incrementer)] != word.charAt(incrementer))
                            found = false;

                        incrementer++;
                    }

                    if (found) {
                        for (int k = 0; k < word.length(); k++) {
                            coordinates.append("(0,").append(j + k).append(")");

                            if (k != word.length() - 1)
                                coordinates.append(",");
                        }
                        break;
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
