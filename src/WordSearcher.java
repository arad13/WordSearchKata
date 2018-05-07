import java.util.List;

class WordSearcher {
    private String lineSeparator = System.getProperty("line.separator");
    private enum FoundType{NOTFOUND, HORIZONTAL, VERTICAL, DIAGONALDESCENDING, DIAGONALASCENDING}

    String Search(List<String> words, char[][] letters){
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder coordinates = new StringBuilder();

            for( int i = 0; i < letters.length; i++ ) {
                for (int j = 0; j < letters[i].length; j++) {
                    if (letters[i][j] == word.charAt(0)) {
                        coordinates.append(searchAroundGivenCoordinate(word, letters, i, j, false));
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

    private String searchAroundGivenCoordinate(String word, char[][] letters, int rowIndex, int columnIndex, boolean reverse) {
        FoundType foundType = FoundType.NOTFOUND;
        StringBuilder result = new StringBuilder();

        int searchTypeIndex = 0;
        while (foundType == FoundType.NOTFOUND && searchTypeIndex < FoundType.values().length){
            switch(searchTypeIndex){
                case 0: foundType = horizontalHelper(word, letters[rowIndex], columnIndex, reverse);
                        break;
                case 1: foundType = verticalHelper(word, letters, rowIndex, columnIndex, reverse);
                        break;
                case 2: foundType = diagonalDescendingHelper(word, letters, rowIndex, columnIndex, reverse);
                        break;
            }
            searchTypeIndex ++;
        }

        if (foundType != FoundType.NOTFOUND) {
            for (int k = 0; k < word.length(); k++) {
                result.append("(").append(rowIndex + (foundType==FoundType.VERTICAL || foundType==FoundType.DIAGONALDESCENDING?k:0)).append(",").append(columnIndex + (foundType==FoundType.HORIZONTAL || foundType==FoundType.DIAGONALDESCENDING?k:0)).append(")");

                if (k != word.length() - 1)
                    result.append(",");
            }
        }

        return result.toString();
    }

    private FoundType horizontalHelper(String word, char[] letterRow, int columnIndex, boolean reverse){
        int incrementer = 1;

        while (incrementer < word.length() && (columnIndex + incrementer) < letterRow.length) {
            if (letterRow[(columnIndex + incrementer)] != word.charAt(incrementer))
                return FoundType.NOTFOUND;

            incrementer++;
        }
        if( incrementer != word.length() )
            return FoundType.NOTFOUND;

        return FoundType.HORIZONTAL;
    }

    private FoundType verticalHelper(String word, char[][] letters, int rowIndex, int columnIndex, boolean upwards){
        int incrementer = 1;

        while (incrementer < word.length() && (rowIndex + incrementer) < letters.length) {
            if (letters[(rowIndex + incrementer)][columnIndex] != word.charAt(incrementer))
                return FoundType.NOTFOUND;

            incrementer++;
        }
        if( incrementer != word.length() )
            return FoundType.NOTFOUND;

        return FoundType.VERTICAL;
    }

    private FoundType diagonalDescendingHelper(String word, char[][] letters, int rowIndex, int columnIndex, boolean reverse){
        int incrementer = 1;

        while (incrementer < word.length() && (rowIndex + incrementer) < letters.length && (columnIndex + incrementer) < letters[rowIndex].length) {
            if (letters[(rowIndex + incrementer)][columnIndex + incrementer] != word.charAt(incrementer))
                return FoundType.NOTFOUND;

            incrementer++;
        }
        if( incrementer != word.length() )
            return FoundType.NOTFOUND;


        return FoundType.DIAGONALDESCENDING;
    }
}
