public class TextData {
    private String fileName; // Filename
    private String text;
    private int numberOfVowels = 0;
    private int numberOfConsonants = 0; // Fixed typo: numberOfConstants to numberOfConsonants
    private int numberOfLetters = 0;
    private int numberOfSentences = 0;
    private String longestWord = "";

    private void analyzeText() {
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                this.numberOfLetters++;
                char lowerChar = Character.toLowerCase(c);
                if ("aeiou".indexOf(lowerChar) >= 0) {
                    this.numberOfVowels++;
                } else {
                    this.numberOfConsonants++;
                }
            }
            if (c == '.' || c == '!' || c == '?') {
                this.numberOfSentences++;
            }
        }
    }

    private void findLongestWord() {
        String[] words = text.split("\\W+");
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                this.longestWord = word;
            }
        }
    }

    // Constructor that accepts only the text
    public TextData(String text) {
        this.text = text; // Store the text
        analyzeText(); // Analyze the text immediately after setting it
        findLongestWord(); // Also find the longest word
    }

    public String getFilename() {
        return fileName; 
    }

    // Setter for fileName (if needed)
    public void setFileName(String fileName) {
        this.fileName = fileName; // Set the filename
    }
    
    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants; 
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() { // Fixed return type
        return longestWord;
    }
}
