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
}
