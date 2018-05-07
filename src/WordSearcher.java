import java.util.List;

class WordSearcher {
    private String lineSeparator = System.getProperty("line.separator");
    private enum FoundType{NOTFOUND, HORIZONTAL, VERTICAL, DIAGONALDESCENDING, DIAGONALASCENDING, HORIZONTALREVERSE, VERTICALREVERSE, DIAGONALDESCENDINGREVERSE}

    String Search(List<String> words, char[][] letters){
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder coordinates = new StringBuilder();

            for( int i = 0; i < letters.length; i++ ) {
                for (int j = 0; j < letters[i].length; j++) {
                    if (letters[i][j] == word.charAt(0)) {
                        coordinates.append(searchAroundGivenCoordinate(word, letters, i, j));
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

    private String searchAroundGivenCoordinate(String word, char[][] letters, int rowIndex, int columnIndex) {
        FoundType foundType = FoundType.NOTFOUND;
        StringBuilder result = new StringBuilder();

        int searchTypeIndex = 0;
        while (foundType == FoundType.NOTFOUND && searchTypeIndex < FoundType.values().length){
            switch(searchTypeIndex){
                case 0: foundType = horizontalHelper(word, letters[rowIndex], columnIndex, false);
                        break;
                case 1: foundType = verticalHelper(word, letters, rowIndex, columnIndex, false);
                        break;
                case 2: foundType = diagonalDescendingHelper(word, letters, rowIndex, columnIndex, false);
                        break;
                case 3: foundType = diagonalAscendingHelper(word, letters, rowIndex, columnIndex, false);
                        break;
                case 4: foundType = horizontalHelper(word, letters[rowIndex], columnIndex, true);
                        break;
                case 5: foundType = verticalHelper(word, letters, rowIndex, columnIndex, true);
                        break;
                case 6: foundType = diagonalDescendingHelper(word, letters, rowIndex, columnIndex, true);
                    break;
            }
            searchTypeIndex ++;
        }

        if (foundType != FoundType.NOTFOUND) {
            for (int k = 0; k < word.length(); k++) {
                result.append("(");
                result.append(columnIndex + (foundType==FoundType.HORIZONTAL || foundType==FoundType.DIAGONALDESCENDING || foundType==FoundType.DIAGONALASCENDING?k:0) + (foundType==FoundType.HORIZONTALREVERSE || foundType==FoundType.DIAGONALDESCENDINGREVERSE?k*-1:0));
                result.append(",");
                result.append(rowIndex + (foundType==FoundType.VERTICAL || foundType==FoundType.DIAGONALDESCENDING || foundType==FoundType.DIAGONALDESCENDINGREVERSE?k:0) + (foundType==FoundType.DIAGONALASCENDING || foundType==FoundType.VERTICALREVERSE?k*-1:0));
                result.append(")");

                if (k != word.length() - 1)
                    result.append(",");
            }
        }

        return result.toString();
    }

    private FoundType horizontalHelper(String word, char[] letterRow, int columnIndex, boolean reverse){
        int incrementer = 1;
        if( reverse )
            incrementer = -1;

        while (incrementer < word.length() && (columnIndex + incrementer) < letterRow.length && (columnIndex + incrementer) >= 0) {
            if (letterRow[(columnIndex + incrementer)] != word.charAt(reverse?incrementer*-1:incrementer))
                return FoundType.NOTFOUND;

            if( reverse )
                incrementer --;
            else
                incrementer ++;
        }
        if( Math.abs(incrementer) != word.length() )
            return FoundType.NOTFOUND;

        if( !reverse )
            return FoundType.HORIZONTAL;
        else
            return FoundType.HORIZONTALREVERSE;
    }

    private FoundType verticalHelper(String word, char[][] letters, int rowIndex, int columnIndex, boolean reverse){
        int incrementer = 1;
        if( reverse )
            incrementer = -1;

        while (incrementer < word.length() && (rowIndex + incrementer) < letters.length && (rowIndex + incrementer) >= 0) {
            if (letters[(rowIndex + incrementer)][columnIndex] != word.charAt(reverse?incrementer*-1:incrementer))
                return FoundType.NOTFOUND;

            if( reverse )
                incrementer --;
            else
                incrementer++;
        }
        if( Math.abs(incrementer) != word.length() )
            return FoundType.NOTFOUND;

        if( !reverse )
            return FoundType.VERTICAL;
        else
            return FoundType.VERTICALREVERSE;
    }

    private FoundType diagonalDescendingHelper(String word, char[][] letters, int rowIndex, int columnIndex, boolean reverse){
        int rowIncrementer = 1;
        int columnIncrementer = 1;
        if( reverse )
            columnIncrementer = -1;

        while (rowIncrementer < word.length() && columnIncrementer < word.length() && (rowIndex + rowIncrementer) < letters.length
                && (columnIndex + columnIncrementer) < letters[rowIndex].length && (columnIndex + columnIncrementer) >= 0) {
            if (letters[(rowIndex + rowIncrementer)][columnIndex + columnIncrementer] != word.charAt(rowIncrementer))
                return FoundType.NOTFOUND;

            rowIncrementer++;
            if( reverse )
                columnIncrementer --;
            else
                columnIncrementer++;
        }
        if( rowIncrementer != word.length() )
            return FoundType.NOTFOUND;

        if( !reverse )
            return FoundType.DIAGONALDESCENDING;
        else
            return FoundType.DIAGONALDESCENDINGREVERSE;
    }

    private FoundType diagonalAscendingHelper(String word, char[][] letters, int rowIndex, int columnIndex, boolean reverse){
        int incrementer = 1;

        while (incrementer < word.length() && (rowIndex - incrementer) >= 0 && (columnIndex + incrementer) < letters[rowIndex].length) {
            if (letters[(rowIndex - incrementer)][columnIndex + incrementer] != word.charAt(incrementer))
                return FoundType.NOTFOUND;

            incrementer++;
        }
        if( incrementer != word.length() )
            return FoundType.NOTFOUND;

        return FoundType.DIAGONALASCENDING;
    }
}
