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
        String directory = System.getProperty("user.dir") + "\\tests\\inputTestFile.txt";

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
        String directory = System.getProperty("user.dir") + "\\tests\\inputTestFile.txt";

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
        String directory = System.getProperty("user.dir") + "\\tests\\inputTestFile2.txt";

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

    @Test
    public void givenLargeGridTestFileReadInFileAndReturnCoordinates(){
        String directory = System.getProperty("user.dir") + "\\tests\\largeInputTestFile.txt";

        InputParser parser = new InputParser();
        parser.parse(directory);
        words = parser.words;
        char[][] letters = parser.letters;

        assertEquals("ADIPISCING: (10,17),(9,16),(8,15),(7,14),(6,13),(5,12),(4,11),(3,10),(2,9),(1,8)" + lineSeparator +
                "AMET: (4,31),(5,31),(6,31),(7,31)" + lineSeparator +
                "BLANDIT: (20,15),(21,14),(22,13),(23,12),(24,11),(25,10),(26,9)" + lineSeparator +
                "CONSECTETUR: (24,4),(23,4),(22,4),(21,4),(20,4),(19,4),(18,4),(17,4),(16,4),(15,4),(14,4)" + lineSeparator +
                "DICTUM: (7,33),(6,34),(5,35),(4,36),(3,37),(2,38)" + lineSeparator +
                "DOLOR: (4,0),(5,1),(6,2),(7,3),(8,4)" + lineSeparator +
                "DONEC: (6,15),(5,16),(4,17),(3,18),(2,19)" + lineSeparator +
                "DUIS: (29,11),(29,12),(29,13),(29,14)" + lineSeparator +
                "EGET: (33,9),(32,8),(31,7),(30,6)" + lineSeparator +
                "ELEIFEND: (28,21),(27,21),(26,21),(25,21),(24,21),(23,21),(22,21),(21,21)" + lineSeparator +
                "ELIT: (6,31),(7,32),(8,33),(9,34)" + lineSeparator +
                "ENIM: (34,36),(34,35),(34,34),(34,33)" + lineSeparator +
                "ERAT: (34,0),(33,1),(32,2),(31,3)" + lineSeparator +
                "FAUCIBUS: (23,18),(22,19),(21,20),(20,21),(19,22),(18,23),(17,24),(16,25)" + lineSeparator +
                "FELIS: (39,19),(38,19),(37,19),(36,19),(35,19)" + lineSeparator +
                "FERMENTUM: (21,36),(21,35),(21,34),(21,33),(21,32),(21,31),(21,30),(21,29),(21,28)" + lineSeparator +
                "IPSUM: (16,26),(17,26),(18,26),(19,26),(20,26)" + lineSeparator +
                "JUSTO: (9,39),(10,38),(11,37),(12,36),(13,35)" + lineSeparator +
                "LECTUS: (2,3),(2,4),(2,5),(2,6),(2,7),(2,8)" + lineSeparator +
                "LIGULA: (31,10),(32,10),(33,10),(34,10),(35,10),(36,10)" + lineSeparator +
                "LOREM: (25,4),(26,3),(27,2),(28,1),(29,0)" + lineSeparator +
                "MASSA: (29,28),(29,29),(29,30),(29,31),(29,32)" + lineSeparator +
                "MATTIS: (20,22),(19,21),(18,20),(17,19),(16,18),(15,17)" + lineSeparator +
                "NAM: (34,21),(35,21),(36,21)" + lineSeparator +
                "NULLA: (20,14),(21,15),(22,16),(23,17),(24,18)" + lineSeparator +
                "NULLAM: (20,14),(21,15),(22,16),(23,17),(24,18),(25,19)" + lineSeparator +
                "NUNC: (35,11),(34,11),(33,11),(32,11)" + lineSeparator +
                "PELLENTESQUE: (11,9),(10,10),(9,11),(8,12),(7,13),(6,14),(5,15),(4,16),(3,17),(2,18),(1,19),(0,20)" + lineSeparator +
                "PRETIUM: (31,27),(31,26),(31,25),(31,24),(31,23),(31,22),(31,21)" + lineSeparator +
                "SIT: (19,7),(18,8),(17,9)" + lineSeparator +
                "SUSCIPIT: (4,9),(5,10),(6,11),(7,12),(8,13),(9,14),(10,15),(11,16)" + lineSeparator +
                "TELLUS: (5,32),(4,32),(3,32),(2,32),(1,32),(0,32)" + lineSeparator +
                "TORTOR: (35,27),(35,26),(35,25),(35,24),(35,23),(35,22)" + lineSeparator +
                "TRISTIQUE: (13,38),(14,38),(15,38),(16,38),(17,38),(18,38),(19,38),(20,38),(21,38)" + lineSeparator +
                "VEHICULA: (32,12),(31,11),(30,10),(29,9),(28,8),(27,7),(26,6),(25,5)" + lineSeparator +
                "VEL: (4,1),(3,2),(2,3)" + lineSeparator +
                "VENENATIS: (11,15),(12,14),(13,13),(14,12),(15,11),(16,10),(17,9),(18,8),(19,7)" + lineSeparator +
                "VITAE: (25,36),(24,35),(23,34),(22,33),(21,32)" + lineSeparator +
                "VOLUTPAT: (19,8),(19,9),(19,10),(19,11),(19,12),(19,13),(19,14),(19,15)", searcher.Search(words, letters));
    }
}
