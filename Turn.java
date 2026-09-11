import java.util.*;

public class Turn {
    int playerGuess;
    Scanner scan = new Scanner(System.in);


    //Requirement 6a.i - two parameters
    //Requirement 6a.ii - return type boolean
    public boolean takeTurn(Players playerName, Hosts hostName) {

        //Requirement 6a.iii - simulate host/player to prompt guess
        System.out.println(
            "Host " + hostName.getFullName() + " says: " + 
            playerName.getFullName() + ", guess my random number between 0 and 100");
        playerGuess = scan.nextInt();

        if (hostName.getNumber().compareNumber(playerGuess)) {

            //Requirement 6a.iv - winning output and piggybank increase
            playerName.setPiggyBank(playerName.getPiggyBank() + playerName.betAmount);
            System.out.println("Congratulations, " + playerName.getFullName() + ", you win!");
            playerName.toString();
            return true;
        }

        else {

            //Requirement 6a.v - losing output and piggybank decrease
            playerName.setPiggyBank(playerName.getPiggyBank() - playerName.betAmount);
            System.out.println("I'm sorry, " + playerName.getFullName() + ", you lose.");
            playerName.toString();
            return false;
        }
    }
}
