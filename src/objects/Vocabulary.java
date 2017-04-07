package objects;

import interfaces.implementations.ErrorDialog;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;


public final class Vocabulary {

    private static Set<String> vocabulary         = new HashSet<>();
    private static ArrayList<Word> fiveLetterWord = new ArrayList<>();


    private static boolean IsCorrectWordForVocabulary(Word possibleWord) {
        return possibleWord.isCorrectWordInUkrainian() && (vocabulary.isEmpty() || vocabulary.add(possibleWord.getString()));
    }

    public Vocabulary() {
        try {
            // read vocabulary from file(in each line only one word)
            ArrayList wordList = new ArrayList();
            InputStream inputStream = Vocabulary.class.getResourceAsStream("vocabulary_for_game.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String word;
            while((word = reader.readLine()) != null) {
                wordList.add(word);
            }

            Iterator iterator = wordList.iterator();

            while(iterator.hasNext()) {
                String line = (String)iterator.next();
                Word possibleWord = new Word(line);
                if(IsCorrectWordForVocabulary(possibleWord)) {
                    vocabulary.add(possibleWord.getString());
                    if(possibleWord.getString().length() == 5) {
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
