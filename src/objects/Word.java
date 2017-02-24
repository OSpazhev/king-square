package objects;

/**
 * Created by Spazhev Oleksandr on 24.02.2017.
 */
public class Word {

    private String word;

    final private char Letters[] = {'а', 'б', 'в', 'г', 'д', 'е', 'є', 'ж', 'з', 'и',
                                    'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
                                    'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь',
                                    'ю', 'я'};


    public Word() {
        word = "";
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public boolean isCorrectWordInUkrainian() {

        boolean incorrectWord = (word.length() == 0);

        for (char letter : word.toCharArray()) {

            boolean incorrectChar = true;

            for (char correctLetter : Letters) {
                incorrectChar &= (correctLetter != letter);
            }

            incorrectWord |= incorrectChar;

        }
        
        incorrectWord |= ((word.length() > 3) && (word.substring(word.length() - 2).equalsIgnoreCase("ий")));

        return !incorrectWord;

    }

}
