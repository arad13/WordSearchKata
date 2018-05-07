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
                case 0: foundType = searchHelper(word, letters, rowIndex, columnIndex, 0, 1); //HorizontalForwards
                        break;
                case 1: foundType = searchHelper(word, letters, rowIndex, columnIndex, 1, 0); //VerticalDownwards
                        break;
                case 2: foundType = searchHelper(word, letters, rowIndex, columnIndex, 1, 1); //DiagonalDescending
                        break;
                case 3: foundType = searchHelper(word, letters, rowIndex, columnIndex, -1, -1); //DiagonalDescendingReverse
                        break;
                case 4: foundType = searchHelper(word, letters, rowIndex, columnIndex, 0, -1); //HorizontalBackwards
                        break;
                case 5: foundType = searchHelper(word, letters, rowIndex, columnIndex, -1, 0); //VerticalUpwards
                        break;
                case 6: foundType = searchHelper(word, letters, rowIndex, columnIndex, -1, 1); //DiagonalAscending
                        break;
                case 7: foundType = searchHelper(word, letters, rowIndex, columnIndex, 1, -1); //DiagonalAscendingReverse
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

    private FoundType searchHelper(String word, char[][] letters, int rowIndex, int columnIndex, int rowIncrementer, int columnIncrementer) {
        while (Math.abs(rowIncrementer) < word.length() && Math.abs(columnIncrementer) < word.length() && (rowIndex + rowIncrementer) < letters.length
                && (columnIndex + columnIncrementer) < letters[rowIndex].length && (rowIndex + rowIncrementer) >= 0 && (columnIndex + columnIncrementer) >= 0) {

            try {
                if (letters[(rowIndex + rowIncrementer)][columnIndex + columnIncrementer] != word.charAt(Math.max(Math.abs(rowIncrementer), Math.abs(columnIncrementer))))
                    return FoundType.NOTFOUND;
            }
            catch(IndexOutOfBoundsException ex){
                return FoundType.NOTFOUND;
            }
            if( rowIncrementer < 0 )
                rowIncrementer --;
            else if( rowIncrementer > 0)
                rowIncrementer ++;

            if( columnIncrementer < 0 )
                columnIncrementer --;
            else if( columnIncrementer > 0)
                columnIncrementer++;
        }
        if( Math.abs(rowIncrementer) != word.length() && Math.abs(columnIncrementer) != word.length() )
            return FoundType.NOTFOUND;

        if( rowIncrementer == 0 && columnIncrementer > 0 )
            return FoundType.HORIZONTAL;
        else if( rowIncrementer > 0 && columnIncrementer == 0 )
            return FoundType.VERTICAL;
        else if( rowIncrementer == 0 && columnIncrementer < 0 )
            return FoundType.HORIZONTALREVERSE;
        else if( rowIncrementer < 0 && columnIncrementer == 0 )
            return FoundType.VERTICALREVERSE;
        else if( rowIncrementer > 0 && columnIncrementer > 0 )
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
