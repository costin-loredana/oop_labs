package com.example.textParser;

public class TextData {
    private String text;
    private int numberOfVowels = 0;
    private int numberOfConsonants = 0;
    private int numberOfLetters = 0;
    private int numberOfSentences = 0;
    private String longestWord = "";

    public TextData(String text) {
        this.text = text;
        analyzeText();
        findLongestWord();
    }

    private void analyzeText() {
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                numberOfLetters++;
                if ("aeiouAEIOU".indexOf(c) >= 0) {
                    numberOfVowels++;
                } else {
                    numberOfConsonants++;
                }
            }
            if (c == '.' || c == '!' || c == '?') {
                numberOfSentences++;
            }
        }
    }

    private void findLongestWord() {
        String[] words = text.split("\\W+");
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
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

    public String getLongestWord() {
        return longestWord;
    }
}
