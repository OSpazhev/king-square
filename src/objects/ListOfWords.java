package objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListOfWords {

    private ObservableList<String> usedWords;

    private void createClearList() {
        usedWords = FXCollections.observableArrayList();
    }

    public ListOfWords(String startWord){
        createClearList();
        usedWords.add(startWord);
    }

    public ListOfWords(Word startWord){
        createClearList();
        usedWords.add(startWord.getString());
    }

    public ListOfWords(){
        createClearList();
    }

    public void add(Word newWord) {
        if (!isUsed(newWord))
            usedWords.add(newWord.getString());
    }

    public boolean isUsed(Word word) {

        boolean flagUsed = false;
        for(String usedWord : usedWords) {

            flagUsed |= usedWord.equals(word.getString());

        }
        return flagUsed;
    }

    public ObservableList<String> getList() {
        return usedWords;
    }

}
