import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Phrases {
    //String gamePhrase which is set on instantiation
    static String gamePhrase = new String();

    //String playingPhrase sets letters as underscores to mask
    String playingPhrase = new String();

    //This would be better than a String
    StringBuilder playingPhraseStringBuilder;

    char underscoreChar = '_';

    boolean phraseSolved = false;




    //New Phrases class should work similarly to Numbers
    public Phrases(String phrase) {
        gamePhrase = phrase.toUpperCase();

        playingPhraseToUnderscore();
    }

    public String getPlayingPhrase() {
        return playingPhrase;
    }

    //Method to make playingPhrase replace letter with underscore
    public void playingPhraseToUnderscore() {
        playingPhrase = gamePhrase.replaceAll("\\S", "_");
        playingPhraseStringBuilder = new StringBuilder(playingPhrase);
    }




    //New method that accepts String as parameter
    public boolean findLetters(String guessString) throws MultipleLettersException, InputMismatchException {
        int x;


        if (guessString.length() <= 0) {
            throw(new InputMismatchException());
        }

    
        //If string longer than 1 letter, throw multi letter exception
        if (guessString.length() > 1) {
            throw(new MultipleLettersException());
        }

        char guessChar = guessString.toUpperCase().charAt(0);


        //Catch and handle the possibility of the user 
        //                entering numbers or symbols instead of letters
        if (! Character.isLetter(guessChar)) {
            throw(new InputMismatchException());
        }

        //Set up Phrases to function similarly to Numbers.java
        //               - compare guess to answer then return statement and boolean

        //if gamePhrase contains guessCharacter
        else if (gamePhrase.indexOf(guessChar) != -1) {
            
            //Find guessed letter in answer and swap underscore with that letter
            
            for (x = 0; x < gamePhrase.length(); ++x) {
                if (gamePhrase.charAt(x) == guessChar)  {
                    playingPhraseStringBuilder.setCharAt(x, guessChar);
                };
            }
            
            playingPhrase = playingPhraseStringBuilder.toString();
            
            //If no more underscores, then player won
            //if playingPhrase contains an underscore, keep playing
            if (playingPhrase.indexOf(underscoreChar) != -1) {
                GamePlay.setPlayingPhraseLabel();
                return true;
            }
            //if playingPhrase NOT contains an underscore, game over
            else if (!(playingPhrase.indexOf(underscoreChar) != -1)) {
                GamePlay.setPlayingPhraseLabel();
                JOptionPane.showMessageDialog(null, "You won! Answer: " + playingPhrase);
                phraseSolved = true;
                return true;
            }

            else {
                return true;
            }

        }
        //if gamePhrase does not contain guessCharacter
        else {
            return false; 
        }

        //extra return of false boolean for exceptions
        //return false; 

    }


    
}
