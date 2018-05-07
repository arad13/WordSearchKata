import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class WordSearchTests {
    @Test
    public void givenSingleWordListAndArrayContainingOnlyWordLettersHorizontallyReturnCoordinates() {
        WordSearcher searcher = new WordSearcher();
        List<String> words = new ArrayList<>();
        words.add("AA");

        char[][] letters = new char[1][2];
        letters[0][0] = 'A';
        letters[0][1] = 'A';

        assertEquals("AA: (0,0),(0,1)", searcher.Search(words, letters));
    }

    @Test
    public void givenADifferentSingleWordListAndArrayContainingOnlyWordLettersHorizontallyReturnCoordinates() {
        WordSearcher searcher = new WordSearcher();
        List<String> words = new ArrayList<>();
        words.add("BB");

        char[][] letters = new char[1][2];
        letters[0][0] = 'B';
        letters[0][1] = 'B';

        assertEquals("BB: (0,0),(0,1)", searcher.Search(words, letters));
    }
}
