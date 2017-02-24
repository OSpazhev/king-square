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

    public Vocabulary(String filePath, String fileName) {

        try {

            List<String> lines = Files.readAllLines(Paths.get(filePath, fileName), StandardCharsets.ISO_8859_1);

            for (String line : lines) {

                line = new String(line.getBytes("ISO-8859-1"), "windows-1251");
                Word buffer = new Word(line);

                if (buffer.isCorrectWordInUkrainian() && ((vocabulary.size() == 0) || (vocabulary.size() > 0) && !buffer.getWord().equals(vocabulary.lastElement().getWord()))) {

                    vocabulary.add(buffer);

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
