public class main {
    public static void main(String[] args){

        System.out.println("Welcome to the word search program!");
        System.out.print("Please enter a file path for a word search puzzle input:");

        String fileInput = System.console().readLine();

        InputParser inputParser = new InputParser();
        inputParser.parse(fileInput);

        WordSearcher wordSearcher = new WordSearcher();
        String results = wordSearcher.Search(inputParser.words, inputParser.letters);
        System.out.print(results);
    }
}
