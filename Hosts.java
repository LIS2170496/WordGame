import java.util.InputMismatchException;
//import java.util.Scanner;

public class Hosts extends Person {
    Phrases winningPhrase;

    public Hosts(String first, String last) {
        super(first, last);
        
    }

    public Hosts(String first) {
        super(first, "");
    }



    //Send Host's chosen phrase to Phrases.java
    //in between method for Try/Catch block for findLetters
    public boolean sendPhrase(String gamePhrase) throws MultipleLettersException, InputMismatchException {

        if (winningPhrase.findLetters(gamePhrase)) {
            GamePlay.setPlayingPhraseLabel();
            return true;
        }
        else {
            GamePlay.setPlayingPhraseLabel();
            return false;
        }
        
    }

    public String getGetPlayingPhrase() {
        return winningPhrase.getPlayingPhrase();
    }

    //Add method to see if phrase has been solved
    public boolean phraseSolved() {
        return winningPhrase.phraseSolved;
    }

    

    


}

