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
                        coordinates.append(horizontalSearcher(word, letters[i], i, j, false));
                        if( !coordinates.toString().equals("") )
                            break;

                        coordinates.append(verticalSearcher(word, letters, i, j, false));
                        if( !coordinates.toString().equals("") )
                            break;

                        coordinates.append(diagonalDescendingSearcher(word, letters, i, j, false ));
                        if( !coordinates.toString().equals("") )
                            break;
                    }
                }

                if( !coordinates.toString().equals("") )
                    break;
            }

            if (!result.toString().equals(""))
                result.append(lineSeparator);
            result.append(word).append(": ").append(coordinates);
        }

        return result.toString();
    }

    private String horizontalSearcher(String word, char[] letterRow, int rowIndex, int columnIndex, boolean backwards){
        int incrementer = 1;
        boolean found = true;
        StringBuilder result = new StringBuilder();

        while (incrementer < word.length() && (columnIndex + incrementer) < letterRow.length) {
            if (letterRow[(columnIndex + incrementer)] != word.charAt(incrementer))
                found = false;

            incrementer++;
        }
        if( incrementer != word.length() )
            found = false;

        if (found) {
            for (int k = 0; k < word.length(); k++) {
                result.append("(").append(rowIndex).append(",").append(columnIndex + k).append(")");

                if (k != word.length() - 1)
                    result.append(",");
            }
        }

        return result.toString();
    }

    private String verticalSearcher(String word, char[][] letters, int rowIndex, int columnIndex, boolean upwards){
        int incrementer = 1;
        boolean found = true;
        StringBuilder result = new StringBuilder();

        while (incrementer < word.length() && (rowIndex + incrementer) < letters.length) {
            if (letters[(rowIndex + incrementer)][columnIndex] != word.charAt(incrementer))
                found = false;

            incrementer++;
        }
        if( incrementer != word.length() )
            found = false;

        if (found) {
            for (int k = 0; k < word.length(); k++) {
                result.append("(").append(rowIndex + k).append(",").append(columnIndex).append(")");

                if (k != word.length() - 1)
                    result.append(",");
            }
        }

        return result.toString();
    }

    private String diagonalDescendingSearcher(String word, char[][] letters, int rowIndex, int columnIndex, boolean reverse){
        int incrementer = 1;
        boolean found = true;
        StringBuilder result = new StringBuilder();

        while (incrementer < word.length() && (rowIndex + incrementer) < letters.length && (columnIndex + incrementer) < letters[rowIndex].length) {
            if (letters[(rowIndex + incrementer)][columnIndex + incrementer] != word.charAt(incrementer))
                found = false;

            incrementer++;
        }
        if( incrementer != word.length() )
            found = false;

        if (found) {
            for (int k = 0; k < word.length(); k++) {
                result.append("(").append(rowIndex + k).append(",").append(columnIndex+k).append(")");

                if (k != word.length() - 1)
                    result.append(",");
            }
        }

        return result.toString();
    }
}
