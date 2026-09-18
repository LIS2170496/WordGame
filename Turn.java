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



        //Requirement 7b - random number to determine money or physical prize
        //Bound 2 creates random int 0 or 1
        //0 will be Money, 1 will be Physical
        int moneyOrPhysical;
        Random random = new Random();
        moneyOrPhysical = random.nextInt(2);


        //Requirement 7b.i - Money prize instantiates Money object
        if (moneyOrPhysical == 0) {
            Money cashPrize = new Money();

            //moved guesses to inside this if statement
            if (numbers.compareNumber(playerGuess)) {
                //Winning output and piggybank increase
                //If player wins, add 5 times the bet amount to their piggy bank
                playerName.setPiggyBank(playerName.getPiggyBank() + 
                    cashPrize.displayWinnings(playerName, true));
                //System.out.println("Congratulations, " + playerName.getFullName() + ", you guessed the number!");
                System.out.println(playerName.toString());
                return true;
            }
            else {
                //Losing output and piggybank decrease
                //If player loses, subtract the bet amount from their piggy bank
                playerName.setPiggyBank(playerName.getPiggyBank() + 
                    cashPrize.displayWinnings(playerName, false));
                //System.out.println("I'm sorry, " + playerName.getFullName() + ", you lose.");
                System.out.println(playerName.toString());
                return false;
            }
        }

        //Requirement 7b.ii - Physical prize instantiates Physical object
        else {
            Physical physicalPrize = new Physical();

            if (numbers.compareNumber(playerGuess)) {
                //Winning output for physical prize
                playerName.setPiggyBank(playerName.getPiggyBank() + 
                    physicalPrize.displayWinnings(playerName, true));
                //System.out.println("Congratulations, " + playerName.getFullName() + ", you guessed the number!");
                System.out.println(playerName.toString());
                return true;
            }
            else {
                //Losing output for physical prize
                playerName.setPiggyBank(playerName.getPiggyBank() + 
                    physicalPrize.displayWinnings(playerName, false));
                //System.out.println("I'm sorry, " + playerName.getFullName() + ", you lose.");
                System.out.println(playerName.toString());
                return false;
            }
        } 
    }



    //Not in requirements list, but in rubric-
    //takeTurn overloaded to accept only Player object, no Host
    public boolean takeTurn(Players playerName) {
        return true;
        //FIXME - not sure what exactly to return
    }


}
