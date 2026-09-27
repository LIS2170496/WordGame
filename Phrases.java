import java.util.InputMismatchException;

public class Phrases {
    //Requirement 6a - String gamePhrase which is set on instantiation
    static String gamePhrase = new String();

    //Requirement 6b - String playingPhrase sets letters as underscores to mask
    String playingPhrase = new String();

    //This would be better than a String
    StringBuilder playingPhraseStringBuilder;

    char underscoreChar = '_';

    boolean phraseSolved = false;




    //Requirement 6. - New Phrases class should work similarly to Numbers
    public Phrases(String phrase) {
        gamePhrase = phrase.toUpperCase();

        playingPhraseToUnderscore();
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
    public boolean findLetters(String guessString) throws MultipleLettersException, InputMismatchException {
        int x;
        char guessChar = guessString.toUpperCase().charAt(0);
        
        //Requirement 6c - If string longer than 1 letter, throw multi letter exception
        if (guessString.length() != 1) {
            //System.out.println("guessString length = " + guessString.length());
            throw(new MultipleLettersException());
        }


        //Requirement 8 - Catch and handle the possibility of the user 
        //                entering numbers or symbols instead of letters
        else if (! Character.isLetter(guessChar)) {
            //System.out.println("in the else if for InputMismatchException, you entered guessString: " + guessString);
            throw(new InputMismatchException());
        }

        

        //if gamePhrase contains guessCharacter
        else if (gamePhrase.indexOf(guessChar) != -1) {
            
            //Requirement 6c - Find guessed letter in answer and swap underscore with that letter
            
            for (x = 0; x < gamePhrase.length(); ++x) {
                if (gamePhrase.charAt(x) == guessChar)  {
                    playingPhraseStringBuilder.setCharAt(x, guessChar);
                };
            }
            
            playingPhrase = playingPhraseStringBuilder.toString();
            
            //Requirement 6c - If no more underscores, then player won
            //if playingPhrase contains an underscore, keep playing
            if (playingPhrase.indexOf(underscoreChar) != -1) {
                System.out.println("There are still more guesses to make");
                return true;
            }
            //if playingPhrase NOT contains an underscore, game over
            else if (!(playingPhrase.indexOf(underscoreChar) != -1)) {
                System.out.println("You won! Answer: " + playingPhrase);
                phraseSolved = true;
                return true;
            }

            //for (x = 0; x < playingPhrase.length(); ++x) {
            //    if (playingPhrase.charAt(x) == '_') {
            //        underscoresLeft = underscoresLeft + 1;
            //    }
            //}
            //System.out.print("There are __" + underscoresLeft + "__ remaining spaces to guess");
            //if (underscoresLeft == 0) {
            //    System.out.println("You won! Answer: " + playingPhrase);
            //    return true;
            //}




            
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
