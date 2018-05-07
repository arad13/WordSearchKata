public class main {
    public static void main(String[] args){
        InputParser inputParser = new InputParser();

        System.out.println("Welcome to the word search program!");
        String result = "Waiting";
        while(!result.equals("") && !result.equals("E")) {
            System.out.print("Please enter a file path for a word search puzzle input or enter E to exit: ");

            String fileInput = System.console().readLine();

            if( fileInput.equals("E") )
                return;

            inputParser = new InputParser();
            result = inputParser.parse(fileInput);


            if(!result.equals(""))
                System.out.println(result);
        }

        WordSearcher wordSearcher = new WordSearcher();
        String results = wordSearcher.Search(inputParser.words, inputParser.letters);
        System.out.print(results);
    }
}
