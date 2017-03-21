package objects;

public class Word {

    final private char LETTERS[] = {'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и',
                                    'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                                    'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'};

    private String     word;


    Word() {
        word = "";
    }

    public Word(String word) {
        this.word = word;
    }

    Word(Word word) {
        this(word.getString());
    }

    public String getString() {
        return word;
    }

    public boolean isCorrectWordInUkrainian() {
        boolean incorrectWord = (word.length() == 0);

        for (char letter : word.toCharArray()) {
            boolean incorrectChar = true;

            for (char correctLetter : LETTERS) {
                incorrectChar &= (correctLetter != letter);
            }

            incorrectWord |= incorrectChar;
        }

        return !incorrectWord;
    }

    boolean equals(Word second) {
        return word.equals(second.getString());
    }

    void removeFirstLetter() {
        if (word.length() > 1) {
            word = word.substring(1, word.length());
        } else {
            word = "";
        }
    }

    char firstLetter() {
        return word.toCharArray()[0];
    }

    int length() {
        return word.length();
    }
}
