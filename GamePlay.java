import java.util.Scanner;

public class GamePlay {

    //private Person field
    //Updated to create new Person at this level 9.9.2026  
    //Person person is now a Players player

    //Removed- no longer used, replaced with array below
    //private Players player = new Players();


    //Requirement 3a - Array of 3 Players
    Players[] currentPlayers = new Players[3];



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Change variables to refer to player instead of person
        String playerFirstName;
        String playerLastName;
        String nameDecision;
        int x;

        //New game 9.9.2026
        GamePlay myGame = new GamePlay();


        //Instantiate Host and generate random number
        Hosts bobBarker = new Hosts("Bob", "Barker");
        bobBarker.randomizeNum();


        //Requirement 3b - Player instantiation is now within a loop for multiplayer
        //Requirement 3b - Players are now part of array currentPlayers

        for (x = 0; x < 3; ++x) {

            //instantiate player in array
            myGame.currentPlayers[x] = new Players();

            //ask for player's name in main
            System.out.println("Player " + (x + 1) + ", enter your first name: ");
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
            //player is now part of array currentPlayers
            if (nameDecision.equals("Y")) {
                System.out.println("Enter your last name: ");
                playerLastName = scan.nextLine();
                myGame.currentPlayers[x].setFirstName(playerFirstName);
                myGame.currentPlayers[x].setLastName(playerLastName);
            }
            else {
                myGame.currentPlayers[x].setFirstName(playerFirstName);
            }

            
        }



        
        

        //Welcome message to confirm what is stored in objects
        System.out.println("\nWelcome, " + 
            myGame.currentPlayers[0].getFullName() + ", " + 
            myGame.currentPlayers[1].getFullName() + ", and " + 
            myGame.currentPlayers[2].getFullName() + "!\n"
        );
        System.out.println("You each have $1,000 in your piggy bank");

        //FIXME - Bet amounts moved from Players.java to Money.java
        //System.out.println("Each guess will bet $" + myGame.player.betAmount);
        //System.out.println("If you guess correctly, you will win $" + myGame.player.winAmount);



        



        //Instantiate Turn
        Turn newTurn = new Turn();


        
        


        


        //Loop to takeTurn until game over (what about if ran out of money)
        //while loop to play the guessing game
        boolean playerWins = false;
        boolean playAgain = true;
        String playAgainDecision;


        //Outer loop for playAgain option
        while (playAgain) {
            playerWins = false;
            playAgainDecision = "";


            //Requirement 3c - Ask for guess from each player until correct answer guessed
            while (!playerWins) {
                //For-each loop through array
                for (Players c : myGame.currentPlayers) {
                    playerWins = newTurn.takeTurn(c, bobBarker);
                    
                    //to get out after number guessed correctly
                    if (playerWins) {
                        break;
                    }
                }
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
