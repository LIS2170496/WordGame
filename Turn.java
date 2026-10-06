import java.util.*;

import javax.swing.JOptionPane;

public class Turn {
    int playerGuess;
    String playerGuessString;
    Scanner scan = new Scanner(System.in);
    boolean guessWasRight;


    //Two parameters
    //Return type boolean
    public boolean takeTurn(Players playerName, Hosts hostName) {
        
        //System.out.println("\nThe phrase to guess is: " + hostName.winningPhrase.playingPhraseStringBuilder);
               
        

        //Simulate host/player to prompt guess
        //System.out.println(
            //"\nHost " + hostName.getFullName() + " says: " + 
            //playerName.getFullName() + ", guess a letter");
        //playerGuessString = scan.nextLine(); <--moved to inside while !continuePlaying


        //Try/Catch block for findLetters and exception handling
        boolean continuePlaying = false;
        
        while (!continuePlaying) {
            try {
                playerGuessString = JOptionPane.showInputDialog(null, playerName.getFullName() + ", enter your guess: ");
                guessWasRight = hostName.sendPhrase(playerGuessString);

            
                continuePlaying = true;
            }
            catch(MultipleLettersException mle) {
                //System.out.println(mle.getMessage() + ", please try again.");
                JOptionPane.showMessageDialog(null, mle.getMessage() + ", please try again.");
                //scan.nextLine();
            }
            catch(InputMismatchException ime) {
                //System.out.println("Input should be a letter character, please try again.");
                JOptionPane.showMessageDialog(null, "Input should be a letter character, please try again.");
                //scan.nextLine();
            }
            //scan.nextLine();
            //Requirement 4f - Set playingPhraseLabel each time playingPhrase updates
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
                //System.out.println(playerName.toString());

                //Requirement 4h  -JOptionPane to give player the message of 
                // whether they were correct and/or won any prizes, 
                // how much money they currently have, etc.
                JOptionPane.showMessageDialog(null, playerName.toString());

                //return false;
                return hostName.phraseSolved();
            }
            else {
                //Losing output and piggybank decrease
                //If player loses, subtract the bet amount from their piggy bank
                playerName.setPiggyBank(playerName.getPiggyBank() + 
                    cashPrize.displayWinnings(playerName, guessWasRight));
                //System.out.println(playerName.toString());

                //Requirement 4h  -JOptionPane to give player the message of 
                // whether they were correct and/or won any prizes, 
                // how much money they currently have, etc.
                JOptionPane.showMessageDialog(null, playerName.toString());
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
                //System.out.println("Congratulations, " + playerName.getFullName() + ", you guessed the number!");
                //System.out.println(playerName.toString());

                //Requirement 4h  -JOptionPane to give player the message of 
                // whether they were correct and/or won any prizes, 
                // how much money they currently have, etc.
                JOptionPane.showMessageDialog(null, playerName.toString());
                //return false;
                return hostName.phraseSolved();
            }
            else {
                //Losing output for physical prize
                playerName.setPiggyBank(playerName.getPiggyBank() + 
                    physicalPrize.displayWinnings(playerName, guessWasRight));
                //System.out.println("I'm sorry, " + playerName.getFullName() + ", you lose.");
                //System.out.println(playerName.toString());

                //Requirement 4h  -JOptionPane to give player the message of 
                // whether they were correct and/or won any prizes, 
                // how much money they currently have, etc.
                JOptionPane.showMessageDialog(null, playerName.toString());
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
