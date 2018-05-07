import java.util.List;

class WordSearcher {
    private String lineSeparator = System.getProperty("line.separator");
    private enum FoundType{NOTFOUND, HORIZONTAL, VERTICAL, DIAGONALDESCENDING, DIAGONALASCENDING, HORIZONTALREVERSE, VERTICALREVERSE, DIAGONALDESCENDINGREVERSE, DIAGONALASCENDINGREVERSE}

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
                case 2: foundType = diagonalHelper(word, letters, rowIndex, columnIndex, 1, 1); //DiagonalDescending
                        break;
                case 3: foundType = diagonalHelper(word, letters, rowIndex, columnIndex, -1, -1); //DiagonalDescendingReverse
                        break;
                case 4: foundType = horizontalHelper(word, letters[rowIndex], columnIndex, true);
                        break;
                case 5: foundType = verticalHelper(word, letters, rowIndex, columnIndex, true);
                        break;
                case 6: foundType = diagonalHelper(word, letters, rowIndex, columnIndex, -1, 1); //DiagonalAscending
                        break;
                case 7: foundType = diagonalHelper(word, letters, rowIndex, columnIndex, 1, -1); //DiagonalAscendingReverse
                        break;
            }
            searchTypeIndex ++;
        }

        if (foundType != FoundType.NOTFOUND) {
            for (int k = 0; k < word.length(); k++) {
                result.append("(");
                result.append(columnIndex + (foundType==FoundType.HORIZONTAL || foundType==FoundType.DIAGONALDESCENDING || foundType==FoundType.DIAGONALASCENDING?k:0) + (foundType==FoundType.HORIZONTALREVERSE || foundType==FoundType.DIAGONALDESCENDINGREVERSE || foundType==FoundType.DIAGONALASCENDINGREVERSE?k*-1:0));
                result.append(",");
                result.append(rowIndex + (foundType==FoundType.VERTICAL || foundType==FoundType.DIAGONALDESCENDING || foundType==FoundType.DIAGONALASCENDINGREVERSE?k:0) + (foundType==FoundType.VERTICALREVERSE || foundType==FoundType.DIAGONALASCENDING || foundType==FoundType.DIAGONALDESCENDINGREVERSE?k*-1:0));
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

    private FoundType diagonalHelper(String word, char[][] letters, int rowIndex, int columnIndex, int rowIncrementer, int columnIncrementer) {
        while (rowIncrementer < word.length() && columnIncrementer < word.length() && (rowIndex + rowIncrementer) < letters.length
                && (columnIndex + columnIncrementer) < letters[rowIndex].length && (rowIndex + rowIncrementer) >= 0 && (columnIndex + columnIncrementer) >= 0) {
            if (letters[(rowIndex + rowIncrementer)][columnIndex + columnIncrementer] != word.charAt(Math.abs(rowIncrementer)))
                return FoundType.NOTFOUND;

            if( rowIncrementer < 0 )
                rowIncrementer --;
            else
                rowIncrementer ++;
            if( columnIncrementer < 0 )
                columnIncrementer --;
            else
                columnIncrementer++;
        }
        if( Math.abs(rowIncrementer) != word.length() )
            return FoundType.NOTFOUND;

        if( rowIncrementer > 0 && columnIncrementer > 0 )
            return FoundType.DIAGONALDESCENDING;
        else if( rowIncrementer < 0 && columnIncrementer < 0 )
            return FoundType.DIAGONALDESCENDINGREVERSE;
        else if( rowIncrementer < 0 && columnIncrementer > 0 )
            return FoundType.DIAGONALASCENDING;
        else if( rowIncrementer > 0 && columnIncrementer < 0 )
            return FoundType.DIAGONALASCENDINGREVERSE;
        else
            return FoundType.NOTFOUND;
    }
}
