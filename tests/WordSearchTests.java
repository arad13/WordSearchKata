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

        assertEquals("AA: (0,0),(0,1)", searcher.Search(words, letters));
    }

    @Test
    public void givenADifferentSingleWordListAndArrayContainingOnlyWordLettersHorizontallyReturnCoordinates() {
        words.add("BB");

        char[][] letters = new char[1][2];
        letters[0][0] = 'B';
        letters[0][1] = 'B';

        assertEquals("BB: (0,0),(0,1)", searcher.Search(words, letters));
    }

    @Test
    public void givenASingleWordAndArrayContainingAFirstLetterNotInWordReturnCoordinates(){
        words.add("AA");

        char[][] letters = new char[1][3];
        letters[0][0] = 'C';
        letters[0][1] = 'A';
        letters[0][2] = 'A';

        assertEquals("AA: (0,1),(0,2)", searcher.Search(words, letters));
    }

    @Test
    public void givenASingleWordOfLengthGreaterThanTwoContainingOnlyWordLettersHorizontallyReturnCoordinates(){
        words.add("AAA");

        char[][] letters = new char[1][3];
        letters[0][0] = 'A';
        letters[0][1] = 'A';
        letters[0][2] = 'A';

        assertEquals("AAA: (0,0),(0,1),(0,2)", searcher.Search(words, letters));
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

        assertEquals("AAA: (0,0),(0,1),(0,2)" + lineSeparator + "BBB: (0,3),(0,4),(0,5)", searcher.Search(words, letters));
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

        assertEquals("AAA: (1,0),(1,1),(1,2)", searcher.Search(words, letters));

    }
}
