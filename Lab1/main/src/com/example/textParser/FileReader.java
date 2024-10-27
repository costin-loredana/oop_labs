package com.example.textParser;
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
}
