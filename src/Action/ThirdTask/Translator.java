package Action.ThirdTask;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {

    JTextField inputTextField;
    JTextArea outputTextArea;

    private static final String DICTIONARY_FILE = "src/Action/ThirdTask/input.txt";

    private Map<String, String> wordMap;

    public Translator() {
        wordMap = new HashMap<>();
    }

    public void loadDictionary() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DICTIONARY_FILE)) ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String word = parts[0].trim().toLowerCase();
                    String translation = parts[1].trim();
                    wordMap.put(word, translation);
                }
            }
        } catch (IOException e) {
            this.outputTextArea.append("Error loading the dictionary!\n");
        }
    }

    public String translateWord(String word) {
        String lowerCaseWord = word.toLowerCase();
        if (wordMap.containsKey(lowerCaseWord)) {
            return wordMap.get(lowerCaseWord);
        }
        return lowerCaseWord;
    }

    public String translateText(String text) {
        StringBuilder translation = new StringBuilder();

        translation.append(translateWord(text));

        if (!translation.isEmpty()) {
            return translation.toString().trim();
        }

        String[] words = text.split("\\s+");
        for (String word : words) {
            String translatedWord = translateWord(word);
            translation.append(translatedWord).append(" ");
        }

        return translation.toString().trim();
    }

    public void run() {
        Translator translator = new Translator();
        translator.loadDictionary();

        String input = this.inputTextField.getText();

        String translatedText = translator.translateText(input);
        this.outputTextArea.append("Translation: " + translatedText + "\n");
    }

    public void setInputText(JTextField inputTextField) {
        this.inputTextField = inputTextField;
    }

    public void setOutputText(JTextArea outputTextArea) {
        this.outputTextArea = outputTextArea;
    }
}