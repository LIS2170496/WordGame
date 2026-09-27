import java.util.InputMismatchException;

public class Phrases {
    //Requirement 6a - String gamePhrase which is set on instantiation
    String gamePhrase = new String();

    //Requirement 6b - String playingPhrase sets letters as underscores to mask
    String playingPhrase = new String();

    //This would be better than a String
    StringBuilder playingPhraseStringBuilder;

    int underscoresLeft = 0;


    //Requirement 6. - New Phrases class can throw MultipleLettersException
    public Phrases(String phrase) throws MultipleLettersException {
        gamePhrase = phrase.toUpperCase();
    }

    //Requirement 6b pt 2 - Method to make playingPhrase replace letter with underscore
    public void playingPhraseToUnderscore() {
        playingPhrase = gamePhrase.replaceAll("\\S", "_");
        playingPhraseStringBuilder = new StringBuilder(playingPhrase);
    }

    //Requirement 6. - Set up Phrases to function similarly to Numbers.java
    //               - compare guess to answer then return statement and boolean
    //FIXME - finish this method later
    public boolean compareCharacter(char guess) {
        return true;
    }

    

    //Requirement 6c - New method that accepts String as parameter
    public void findLetters(String guessString) throws MultipleLettersException, InputMismatchException {
        int x;
        char guessChar = guessString.toUpperCase().charAt(0);
        
        //Requirement 6c - If string longer than 1 letter, throw multi letter exception
        if (guessString.length() != 1) {
            throw(new MultipleLettersException());
        }


        //Requirement 8 - Catch and handle the possibility of the user 
        //                entering numbers or symbols instead of letters
        else if (! Character.isLetter(guessChar)) {
            throw(new InputMismatchException());
        }


        //Requirement 6c - Find guessed letter in answer and swap underscore with that letter
        else {
            for (x = 0; x < gamePhrase.length(); ++x) {
                if (gamePhrase.charAt(x) == guessChar)  {
                    playingPhraseStringBuilder.setCharAt(x, guessChar);
                };
            }
            playingPhrase = playingPhraseStringBuilder.toString();
        }


        //Requirement 6c - If no more underscores, then player won
        for (x = 0; x < playingPhrase.length(); ++x) {
            if (playingPhrase.charAt(x) == '_') {
                underscoresLeft = underscoresLeft + 1;
            }
        }
        if (underscoresLeft == 0) {
            System.out.println("You won! Answer: " + playingPhrase);
        }
        

    }


    
}
