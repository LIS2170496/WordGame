import java.util.*;
import javax.swing.JOptionPane;

public class Turn {
    int playerGuess;
    String playerGuessString;
    boolean guessWasRight;


    //Two parameters
    //Return type boolean
    public boolean takeTurn(Players playerName, Hosts hostName) {
        
        //Try/Catch block for findLetters and exception handling
        boolean continuePlaying = false;
        
        while (!continuePlaying) {
            try {
                playerGuessString = null;

                while (playerGuessString == null  ||  playerGuessString.equals("")) {

                    playerGuessString = JOptionPane.showInputDialog(null, playerName.getFullName() + ", enter your guess: ");

                    //LESSON10 - once next player has entered their guess, 
                    //           remove the previous player's prize image and 
                    //           continue with turns

                    GamePlay.removePrizeImage();
                    if (playerGuessString == null) {
                        return false;
                    }
                }
                
                guessWasRight = hostName.sendPhrase(playerGuessString);

            
                continuePlaying = true;
            }
            catch(MultipleLettersException mle) {
                JOptionPane.showMessageDialog(null, mle.getMessage() + ", please try again.");
            }
            catch(InputMismatchException ime) {
                JOptionPane.showMessageDialog(null, "Input should be a letter character, please try again.");
            }
            //Set playingPhraseLabel each time playingPhrase updates
            GamePlay.setPlayingPhraseLabel();


            
        }



        //Random number to determine money or physical prize
        //Bound 2 creates random int 0 or 1
        //0 will be Money, 1 will be Physical
        int moneyOrPhysical;
        Random random = new Random();
        moneyOrPhysical = random.nextInt(2);


        //Money prize instantiates Money object
        if (moneyOrPhysical == 0) {
            Money cashPrize = new Money();

            //moved guesses to inside this if statement
            //swapped compareNumber for sendPhrase
            //if (numbers.compareNumber(playerGuess)) {
            if (guessWasRight) {

                //
                //Winning output and piggybank increase
                //If player wins, add 5 times the bet amount to their piggy bank
                playerName.setPiggyBank(playerName.getPiggyBank() + 
                    cashPrize.displayWinnings(playerName, guessWasRight));

                //Text area message to give player the message of 
                // whether they were correct and/or won any prizes, 
                // how much money they currently have, etc.

                //This message is appended to the textArea instead of using
                // the setTextArea method so that the player can read it.
                //If the setTextArea were used at this point, the message
                // from the Money or Physical prize class would be overridden
                // too quickly for the player to read it.
                GamePlay.textArea.append("\n" + playerName.toString());
                GamePlay.textArea.setCaretPosition(GamePlay.textArea.getDocument().getLength());

                //return false;
                return hostName.phraseSolved();
            }
            else {
                //Losing output and piggybank decrease
                //If player loses, subtract the bet amount from their piggy bank
                playerName.setPiggyBank(playerName.getPiggyBank() + 
                    cashPrize.displayWinnings(playerName, guessWasRight));

                //Text area message to give player the message of 
                // whether they were correct and/or won any prizes, 
                // how much money they currently have, etc.

                //This message is appended to the textArea instead of using
                // the setTextArea method so that the player can read it.
                //If the setTextArea were used at this point, the message
                // from the Money or Physical prize class would be overridden
                // too quickly for the player to read it.
                GamePlay.textArea.append("\n" + playerName.toString());
                GamePlay.textArea.setCaretPosition(GamePlay.textArea.getDocument().getLength());
                //return false;
                return hostName.phraseSolved();
            }
        }

        //Physical prize instantiates Physical object
        else {
            Physical physicalPrize = new Physical();

            //swapped compareNumber for sendPhrase
            //if (numbers.compareNumber(playerGuess)) {
            if (guessWasRight) {
                //Winning output for physical prize
                playerName.setPiggyBank(playerName.getPiggyBank() + 
                    physicalPrize.displayWinnings(playerName, guessWasRight));

                //Text area message to give player the message of 
                // whether they were correct and/or won any prizes, 
                // how much money they currently have, etc.

                //This message is appended to the textArea instead of using
                // the setTextArea method so that the player can read it.
                //If the setTextArea were used at this point, the message
                // from the Money or Physical prize class would be overridden
                // too quickly for the player to read it.
                GamePlay.textArea.append("\n" + playerName.toString());
                GamePlay.textArea.setCaretPosition(GamePlay.textArea.getDocument().getLength());
                //return false;
                return hostName.phraseSolved();
            }
            else {
                //Losing output for physical prize
                playerName.setPiggyBank(playerName.getPiggyBank() + 
                    physicalPrize.displayWinnings(playerName, guessWasRight));

                //Text area message to give player the message of 
                // whether they were correct and/or won any prizes, 
                // how much money they currently have, etc.

                //This message is appended to the textArea instead of using
                // the setTextArea method so that the player can read it.
                //If the setTextArea were used at this point, the message
                // from the Money or Physical prize class would be overridden
                // too quickly for the player to read it.
                GamePlay.textArea.append("\n" + playerName.toString());
                GamePlay.textArea.setCaretPosition(GamePlay.textArea.getDocument().getLength());
                //return false;
                return hostName.phraseSolved();
            }
        } 
    }



    //Not in requirements list, but in rubric-
    //takeTurn overloaded to accept only Player object, no Host
    public boolean takeTurn(Players playerName) {
        return true;
    }


}
