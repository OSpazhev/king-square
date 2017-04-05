package objects;

import interfaces.implementations.ErrorDialog;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;


public final class Vocabulary {

    private static Set<String> vocabulary           = new HashSet<>();
    private static ArrayList<Word> fiveLetterWord = new ArrayList<>();


    private static boolean IsCorrectWordForVocabulary(Word possibleWord) {
        return possibleWord.isCorrectWordInUkrainian() && (vocabulary.isEmpty() || vocabulary.add(possibleWord.getString()));
    }

    public Vocabulary() {
        try {
            // read vocabulary from file(in each line only one word)
            File txtVocabulary = new File("vocabularies/vocabulary_for_game.txt");
            List<String> lines = Files.readAllLines(txtVocabulary.toPath(), StandardCharsets.UTF_8);

            for (String line : lines) {
                //line = new String(line.getBytes("ISO-8859-1"), "windows-1251");
                Word possibleWord = new Word(line);
                if (IsCorrectWordForVocabulary(possibleWord)) {
                    vocabulary.add(possibleWord.getString());
                    if (possibleWord.getString().length() == 5) {
                        fiveLetterWord.add(possibleWord);
                    }
                }
            }
        } catch (IOException e) {
            ErrorDialog.callDialog("Проблеми із словником", "Можливо проблема виникла при завантаження словника");
        }
    }

    public static Word getFiveLetterWord() {
        Random rand = new Random();

        return fiveLetterWord.get(Math.abs(rand.nextInt()) % fiveLetterWord.size());
    }

    public static boolean isWordInVocabulary(Word possibleWord) {
        return vocabulary.contains(possibleWord.getString());
    }

}
