import java.util.*;

public class Turn {
    int playerGuess;
    Scanner scan = new Scanner(System.in);


    //Two parameters
    //Return type boolean
    public boolean takeTurn(Players playerName, Hosts hostName) {

        //Simulate host/player to prompt guess
        System.out.println(
            "\nHost " + hostName.getFullName() + " says: " + 
            playerName.getFullName() + ", guess my random number between 0 and 100");
        playerGuess = scan.nextInt();


        //Updated per rubric to have Turn instantiate Numbers to check the guess
        //Previously, my 'if' statement went through the Host using hostName.verifyGuess(playerGuess)
        Numbers numbers = new Numbers();


        if (numbers.compareNumber(playerGuess)) {

            //Winning output and piggybank increase
            //If player wins, add 5 times the bet amount to their piggy bank
            playerName.setPiggyBank(playerName.getPiggyBank() + (playerName.winAmount));
            System.out.println("Congratulations, " + playerName.getFullName() + ", you guessed the number!");
            System.out.println(playerName.toString());
            return true;
        }

        else {

            //Losing output and piggybank decrease
            //If player loses, subtract the bet amount from their piggy bank
            playerName.setPiggyBank(playerName.getPiggyBank() - playerName.betAmount);
            //System.out.println("I'm sorry, " + playerName.getFullName() + ", you lose.");
            System.out.println(playerName.toString());
            return false;
        }
    }



    //Not in requirements list, but in rubric-
    //takeTurn overloaded to accept only Player object, no Host
    public boolean takeTurn(Players playerName) {
        return true;
        //FIXME - not sure what exactly to return
    }


}
