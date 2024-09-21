package backend.academy.gallow_game.states;

import lombok.Getter;
import lombok.Setter;

@Setter
public class WordStateManager {

    private String word;

    @Getter private String correctWord;

    public void changeLetter(String letter) {
        this.word = word.replace(letter, "_");
    }

    public boolean wordIsGuessed() {
        for (int i = 0; i < this.word.length(); i++) {
            if (!(word.charAt(i) == '_')) {
                return false;
            }
        }
        return true;
    }

    public String getEncodedWord() {
        StringBuilder resultWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != '_') {
                resultWord.append('_');
            } else {
                resultWord.append(correctWord.charAt(i));
            }
        }

        return resultWord.toString();
    }

    public boolean contains(String letter) {
        return this.word.contains(letter);
    }
}
