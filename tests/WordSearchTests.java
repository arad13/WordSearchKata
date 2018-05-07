import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class WordSearchTests {
    private WordSearcher searcher = new WordSearcher();
    private List<String> words = new ArrayList<>();
    private String lineSeparator = System.getProperty("line.separator");

    @Test
    public void givenASingleWordListAndArrayContainingOnlyWordLettersHorizontallyReturnCoordinates() {
        words.add("AA");

        char[][] letters = new char[1][2];
        letters[0][0] = 'A';
        letters[0][1] = 'A';

        assertEquals("AA: (0,0),(1,0)", searcher.Search(words, letters));
    }

    @Test
    public void givenADifferentSingleWordListAndArrayContainingOnlyWordLettersHorizontallyReturnCoordinates() {
        words.add("BB");

        char[][] letters = new char[1][2];
        letters[0][0] = 'B';
        letters[0][1] = 'B';

        assertEquals("BB: (0,0),(1,0)", searcher.Search(words, letters));
    }

    @Test
    public void givenASingleWordAndArrayContainingAFirstLetterNotInWordReturnCoordinates(){
        words.add("AA");

        char[][] letters = new char[1][3];
        letters[0][0] = 'C';
        letters[0][1] = 'A';
        letters[0][2] = 'A';

        assertEquals("AA: (1,0),(2,0)", searcher.Search(words, letters));
    }

    @Test
    public void givenASingleWordOfLengthGreaterThanTwoContainingOnlyWordLettersHorizontallyReturnCoordinates(){
        words.add("AAA");

        char[][] letters = new char[1][3];
        letters[0][0] = 'A';
        letters[0][1] = 'A';
        letters[0][2] = 'A';

        assertEquals("AAA: (0,0),(1,0),(2,0)", searcher.Search(words, letters));
    }

    @Test
    public void givenTwoWordsHorizontallyReturnCoordinates(){
        words.add("AAA");
        words.add("BBB");

        char[][] letters = new char[1][6];
        letters[0][0] = 'A';
        letters[0][1] = 'A';
        letters[0][2] = 'A';
        letters[0][3] = 'B';
        letters[0][4] = 'B';
        letters[0][5] = 'B';

        assertEquals("AAA: (0,0),(1,0),(2,0)" + lineSeparator + "BBB: (3,0),(4,0),(5,0)", searcher.Search(words, letters));
    }

    @Test
    public void givenASingleWordHorizontallyWithLettersNotOnFirstLineReturnCoordinates(){
        words.add("AAA");

        char[][] letters = new char[2][3];
        letters[0][0] = 'B';
        letters[0][1] = 'B';
        letters[0][2] = 'B';
        letters[1][0] = 'A';
        letters[1][1] = 'A';
        letters[1][2] = 'A';

        assertEquals("AAA: (0,1),(1,1),(2,1)", searcher.Search(words, letters));
    }

    @Test
    public void givenASingleWordSearchVerticallyLettersInFirstColumnReturnCoordinates(){
        words.add("AAA");

        char[][] letters = new char[3][1];
        letters[0][0] = 'A';
        letters[1][0] = 'A';
        letters[2][0] = 'A';

        assertEquals("AAA: (0,0),(0,1),(0,2)", searcher.Search(words, letters));
    }

    @Test
    public void givenMultipleWordsSearchVerticallyInMultipleColumnsReturnCoordinates(){
        words.add("AAA");
        words.add("BBB");

        char[][] letters = new char[3][3];
        letters[0][0] = 'C';
        letters[1][0] = 'C';
        letters[2][0] = 'C';
        letters[0][1] = 'A';
        letters[1][1] = 'A';
        letters[2][1] = 'A';
        letters[0][2] = 'B';
        letters[1][2] = 'B';
        letters[2][2] = 'B';

        assertEquals("AAA: (1,0),(1,1),(1,2)" + lineSeparator + "BBB: (2,0),(2,1),(2,2)", searcher.Search(words, letters));
    }

    @Test
    public void givenASingleWordSearchDiagonallyDescendingReturnCoordinates(){
        words.add("AAA");

        char[][] letters = new char[3][3];
        letters[0][0] = 'A';
        letters[0][1] = 'B';
        letters[0][2] = 'C';
        letters[1][0] = 'B';
        letters[1][1] = 'A';
        letters[1][2] = 'C';
        letters[2][0] = 'B';
        letters[2][1] = 'C';
        letters[2][2] = 'A';

        assertEquals("AAA: (0,0),(1,1),(2,2)", searcher.Search(words, letters));
    }

    @Test
    public void givenMultipleWordsSearchDiagonallyDescendingReturnCoordinates(){
        words.add("AAA");
        words.add("BD");

        char[][] letters = new char[3][3];
        letters[0][0] = 'A';
        letters[0][1] = 'B';
        letters[0][2] = 'C';
        letters[1][0] = 'B';
        letters[1][1] = 'A';
        letters[1][2] = 'C';
        letters[2][0] = 'B';
        letters[2][1] = 'D';
        letters[2][2] = 'A';

        assertEquals("AAA: (0,0),(1,1),(2,2)" + lineSeparator + "BD: (0,1),(1,2)", searcher.Search(words, letters));
    }

    @Test
    public void givenMultipleWordsSearchDiagonallyAscendingReturnCoordinates(){
        words.add("FOO");
        words.add("BD");

        char[][] letters = new char[3][3];
        letters[0][0] = 'C';
        letters[0][1] = 'D';
        letters[0][2] = 'O';
        letters[1][0] = 'B';
        letters[1][1] = 'O';
        letters[1][2] = 'C';
        letters[2][0] = 'F';
        letters[2][1] = 'E';
        letters[2][2] = 'A';

        assertEquals("FOO: (0,2),(1,1),(2,0)" + lineSeparator + "BD: (0,1),(1,0)", searcher.Search(words, letters));
    }

    @Test
    public void givenMultipleWordsSearchHorizontallyInReverseReturnCoordinates(){
        words.add("FOO");
        words.add("BAR");

        char[][] letters = new char[2][3];
        letters[0][0] = 'O';
        letters[0][1] = 'O';
        letters[0][2] = 'F';
        letters[1][0] = 'R';
        letters[1][1] = 'A';
        letters[1][2] = 'B';

        assertEquals("FOO: (2,0),(1,0),(0,0)" + lineSeparator + "BAR: (2,1),(1,1),(0,1)", searcher.Search(words, letters));
    }

    @Test
    public void givenMultipleWordsSearchVerticallyInReverseReturnCoordinates(){
        words.add("FOO");
        words.add("BAR");

        char[][] letters = new char[3][2];
        letters[0][0] = 'O';
        letters[0][1] = 'R';
        letters[1][0] = 'O';
        letters[1][1] = 'A';
        letters[2][0] = 'F';
        letters[2][1] = 'B';

        assertEquals("FOO: (0,2),(0,1),(0,0)" + lineSeparator + "BAR: (1,2),(1,1),(1,0)", searcher.Search(words, letters));
    }

    @Test
    public void givenMultipleWordsSearchDiagonallyDescendingInReverseReturnCoordinates(){
        words.add("FOO");
        words.add("BD");

        char[][] letters = new char[3][3];
        letters[0][0] = 'C';
        letters[0][1] = 'B';
        letters[0][2] = 'F';
        letters[1][0] = 'D';
        letters[1][1] = 'O';
        letters[1][2] = 'C';
        letters[2][0] = 'O';
        letters[2][1] = 'D';
        letters[2][2] = 'A';

        assertEquals("FOO: (2,0),(1,1),(0,2)" + lineSeparator + "BD: (1,0),(0,1)", searcher.Search(words, letters));
    }

    @Test
    public void givenMultipleWordsSearchDiagonallyAscendingInReverseReturnCoordinates(){
        words.add("FOO");
        words.add("BD");

        char[][] letters = new char[3][3];
        letters[0][0] = 'O';
        letters[0][1] = 'D';
        letters[0][2] = 'C';
        letters[1][0] = 'E';
        letters[1][1] = 'O';
        letters[1][2] = 'B';
        letters[2][0] = 'A';
        letters[2][1] = 'E';
        letters[2][2] = 'F';

        assertEquals("FOO: (2,2),(1,1),(0,0)" + lineSeparator + "BD: (2,1),(1,0)", searcher.Search(words, letters));
    }

    @Test
    public void readInFileAndReturnWordsList(){
        String directory = "D:\\Andrew\\Documents\\inputTestFile.txt";

        InputParser parser = new InputParser();
        parser.parse(directory);
        words = parser.words;

        ArrayList<String> resultList = new ArrayList<>();
        resultList.add("BONES");
        resultList.add("KHAN");
        resultList.add("KIRK");
        resultList.add("SCOTTY");
        resultList.add("SPOCK");
        resultList.add("SULU");
        resultList.add("UHURA");

        assertEquals(resultList, words);
    }

    @Test
    public void readInFileAndReturnLettersArray(){
        String directory = "D:\\Andrew\\Documents\\inputTestFile.txt";

        InputParser parser = new InputParser();
        parser.parse(directory);
        char[][] letters = parser.letters;

        char[][] lettersToCheck = new char[2][15];
        lettersToCheck[0][0] = 'U';
        lettersToCheck[0][1] = 'M';
        lettersToCheck[0][2] = 'K';
        lettersToCheck[0][3] = 'H';
        lettersToCheck[0][4] = 'U';
        lettersToCheck[0][5] = 'L';
        lettersToCheck[0][6] = 'K';
        lettersToCheck[0][7] = 'I';
        lettersToCheck[0][8] = 'N';
        lettersToCheck[0][9] = 'V';
        lettersToCheck[0][10] = 'J';
        lettersToCheck[0][11] = 'O';
        lettersToCheck[0][12] = 'C';
        lettersToCheck[0][13] = 'W';
        lettersToCheck[0][14] = 'E';
        lettersToCheck[1][0] = 'L';
        lettersToCheck[1][1] = 'L';
        lettersToCheck[1][2] = 'S';
        lettersToCheck[1][3] = 'H';
        lettersToCheck[1][4] = 'K';
        lettersToCheck[1][5] = 'Z';
        lettersToCheck[1][6] = 'Z';
        lettersToCheck[1][7] = 'W';
        lettersToCheck[1][8] = 'Z';
        lettersToCheck[1][9] = 'C';
        lettersToCheck[1][10] = 'G';
        lettersToCheck[1][11] = 'J';
        lettersToCheck[1][12] = 'U';
        lettersToCheck[1][13] = 'Y';
        lettersToCheck[1][14] = 'G';

        Assert.assertArrayEquals(lettersToCheck, letters);
    }

    @Test
    public void givenSampleInputFileReadInFileAndReturnCoordinates(){
        String directory = "D:\\Andrew\\Documents\\inputTestFile2.txt";

        InputParser parser = new InputParser();
        parser.parse(directory);
        words = parser.words;
        char[][] letters = parser.letters;

        assertEquals("BONES: (0,6),(0,7),(0,8),(0,9),(0,10)" + lineSeparator +
                "KHAN: (5,9),(5,8),(5,7),(5,6)" + lineSeparator +
                "KIRK: (4,7),(3,7),(2,7),(1,7)" + lineSeparator +
                "SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)" + lineSeparator +
                "SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)" + lineSeparator +
                "SULU: (3,3),(2,2),(1,1),(0,0)" + lineSeparator +
                "UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)", searcher.Search(words, letters));
    }
}
