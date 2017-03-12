package objects;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

/**
 * Created by Spazhev Oleksandr on 24.02.2017.
 */
public class Vocabulary {

    private Vector<Word> vocabulary = new Vector<Word>();

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

    public Vocabulary(String filePath, String fileName) {

        try {

            // read vocabluary from file(in each line only one word)
            List<String> lines = Files.readAllLines(Paths.get(filePath, fileName), StandardCharsets.ISO_8859_1);

            for (String line : lines) {

                line = new String(line.getBytes("ISO-8859-1"), "windows-1251");
                Word possibleWord = new Word(line);

                if (IsCorrectWordForVocabulary(possibleWord)) {

                    vocabulary.add(possibleWord);

                }

            }

        } catch (IOException e) {

            System.out.println("Something wrong with vocabulary file");
            e.printStackTrace();

        }

    }

}
