import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

    public String readFileIntoString(String path) throws IOException {
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append(System.lineSeparator());
            }
        }
        return data.toString();
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Error: Please provide the path to the .txt file as a command-line argument.");
            return;
        }

        String filePath = args[0];
        FileReader fileReader = new FileReader();
        try {
            String data = fileReader.readFileIntoString(filePath);
            // Create a TextData object using the data read from the file
            TextData textData = new TextData(data);
            
            // Output the results of the text analysis (you can add methods to print specific results)
            System.out.println("Text Analysis:");
            System.out.println("Text: " + textData.getText());
            System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
            System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
            System.out.println("Number of Letters: " + textData.getNumberOfLetters());
            System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
            System.out.println("Longest Word: " + textData.getLongestWord());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
