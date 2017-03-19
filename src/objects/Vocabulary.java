package objects;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;


public class Vocabulary {

    private Vector<Word> vocabulary     = new Vector<Word>();
    private ArrayList<Word> fiveLetterWord = new ArrayList<Word>();

    private boolean IsCorrectWordForVocabulary(Word possibleWord) {

        boolean flag = false;

        if (possibleWord.isCorrectWordInUkrainian()) {

            if (vocabulary.isEmpty()) {

                flag = true;

            } else if (!possibleWord.getWord().equals(vocabulary.lastElement().getWord())){

                flag = true;

            }

        }

        return flag;

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

                    vocabulary.add(possibleWord);

                    if (possibleWord.getWord().length() == 5) {

                        fiveLetterWord.add(possibleWord);

                    }

                }

            }

        } catch (IOException e) {

            System.out.println("Something wrong with vocabulary file");
            e.printStackTrace();

        }

    }

    public Word getFiveLetterWord() {

        Random rand = new Random();

        return fiveLetterWord.get(Math.abs(rand.nextInt()) % fiveLetterWord.size());
    }

    public boolean isWordInVocabulary(Word possibleWord)
    {

        boolean flagWordInVocabulary = false;

        for (Word vocabularyWord : vocabulary) {
            if (vocabularyWord.equals(possibleWord))
            {
                flagWordInVocabulary = true;
            }
        }

        return flagWordInVocabulary;
    }

}
