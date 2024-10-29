package com.example.textParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    public String readFileIntoString(String path) throws IOException {
        StringBuilder data = new StringBuilder();
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append(System.lineSeparator());
            }
        }
        return data.toString();
    }

    public void performTextAnalysis(List<File> files) {
        if (files == null || files.isEmpty()) {
            System.out.println("No files provided for analysis.");
            return;
        }

        for (File file : files) {
            try {
                String data = readFileIntoString(file.getAbsolutePath());
                TextData textData = new TextData(data);

                System.out.println("Text Analysis for " + file.getName() + ":");
                System.out.println("Text: " + textData.getText());
                System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
                System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
                System.out.println("Number of Letters: " + textData.getNumberOfLetters());
                System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
                System.out.println("Longest Word: " + textData.getLongestWord());
                System.out.println();
            } catch (IOException e) {
                System.err.println("Error reading file " + file.getName() + ": " + e.getMessage());
            }
        }
    }

    public List<File> getTextFilesInDirectory(String directoryPath) {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println("Found file: " + file.getName());
            }
        } else {
            System.out.println("No .txt files found in directory: " + directoryPath);
        }

        return files != null ? Arrays.asList(files) : new ArrayList<>();
    }
}
