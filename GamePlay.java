import java.util.Scanner;

public class GamePlay {

    //private Person field
    //Updated to create new Person at this level 9.9.2026  
    //Person person is now a Players player
    private Players player = new Players();


    //Requirement 3a - Array of 3 Players
    Players[3] currentPlayers = new Players[3];



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Change variables to refer to player instead of person
        String playerFirstName;
        String playerLastName;
        String nameDecision;

        //New game 9.9.2026
        GamePlay myGame = new GamePlay();


        //Instantiate Host and generate random number
        Hosts bobBarker = new Hosts("Bob", "Barker");
        bobBarker.randomizeNum();





        //ask for player's name in main
        System.out.println("Player 1, enter your first name: ");
        playerFirstName = scan.nextLine();

        //ask if they want to add last name
        System.out.println("Would you like to add your last name? (Y / N)");
        nameDecision = scan.nextLine();
        

        //prevent invalid entry
        while (!nameDecision.equals("Y")  &&  !nameDecision.equals("N")) {
            System.out.println("Would you like to add your last name? (Y / N)");
            nameDecision = scan.nextLine();
        }


        
        //Constructor for Person depending on fname or fname+lname
        //Updated player1 to myGame.person  9.9.2026
        //Updated myGame.person to myGame.player 9.11.2026
        if (nameDecision.equals("Y")) {
            System.out.println("Enter your last name: ");
            playerLastName = scan.nextLine();
            myGame.player.setFirstName(playerFirstName);
            myGame.player.setLastName(playerLastName);
        }
        else {
            myGame.player.setFirstName(playerFirstName);
        }
        

        //Welcome message to confirm what is stored in Person object
        //Updated player1 to myGame.person  9.9.2026
        //Updated myGame.person to myGame.player 9.11.2026
        System.out.println("\nWelcome, " + myGame.player.getFullName() );
        System.out.println("You have $1,000 in your piggy bank");
        System.out.println("Each guess will bet $" + myGame.player.betAmount);
        System.out.println("If you guess correctly, you will win $" + myGame.player.winAmount);



        


        //Removed this section
        //New Numbers instance that generates a random number
        //Numbers aRandomNumber = new Numbers();
        //aRandomNumber.generateNumber();


        //Instantiate Turn
        Turn newTurn = new Turn();


        
        


        //Move this prompt to takeTurn method
        //int playerGuess;
        //boolean guessCorrect = false;
        //while (!guessCorrect) {
        //    System.out.println(myGame.player.getFullName() + ", guess my random number between 0 and 100");
        //    playerGuess = scan.nextInt();
        //    guessCorrect = aRandomNumber.compareNumber(playerGuess);
        //}


        //Loop to takeTurn until game over (what about if ran out of money)
        //while loop to play the guessing game
        boolean playerWins = false;
        boolean playAgain = true;
        String playAgainDecision;


        //Outer loop for playAgain option
        while (playAgain) {
            playerWins = false;
            playAgainDecision = "";

            while (!playerWins) {
                playerWins = newTurn.takeTurn(myGame.player, bobBarker);
            }

            //prevent invalid entry
            while (!playAgainDecision.equals("Y")  &&  !playAgainDecision.equals("N")) {
                System.out.println("\nWould you like to play again? (Y / N)");
                playAgainDecision = scan.nextLine();
            }

            
            if (playAgainDecision.equals("Y")) {
                playAgain = true;
                //Generate new random number
                bobBarker.randomizeNum();
            }
            else {
                playAgain = false;
            }

        }

        


        System.out.println("Thanks for playing!");









        //Close scanner to get rid of problem alert in vscode
        scan.close(); 

    }

}
