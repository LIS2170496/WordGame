import java.util.Scanner;

public class GamePlay {


    public static Players[] currentPlayers = new Players[3];

    public static void addNewPlayer(int i, String fname, String lname) {
        //Player creation now part of new method
        currentPlayers[i] = new Players();
        currentPlayers[i].setFirstName(fname);
        currentPlayers[i].setLastName(lname);
    }



    public static void main(String[] args) {

        //Requirement 4a - New JFrame via GUI
        GUI gameWindow = new GUI();


        Scanner scan = new Scanner(System.in);


        GamePlay myGame = new GamePlay();


        Hosts bobBarker = new Hosts("Bob", "Barker");
        



        //Requirement 4b - Set JLabel to list current players
        gameWindow.currentPlayersLabel.setText("Current Players: " + 
            currentPlayers[0].getFullName() + ", " + 
            currentPlayers[1].getFullName() + ", " + 
            currentPlayers[2].getFullName()
        );


        //Requirement 4d - Set JLavel to display current host full name
        gameWindow.currentHostLabel.setText("Current Host: " + bobBarker.getFullName());
        
        


        //Welcome message to confirm what is stored in objects
        System.out.println("\nWelcome, " + 
            currentPlayers[0].getFullName() + ", " + 
            currentPlayers[1].getFullName() + ", and " + 
            currentPlayers[2].getFullName() + "!\n"
        );
        System.out.println("You each have $1,000 in your piggy bank");

        //Now guessing incorrectly on a possible Physical prize loses $0 instead of $10?
        //System.out.println("Each guess will bet $" + Money.betAmount);

        System.out.println("If you guess correctly, you will win $" + Money.winAmount + 
            " or a random physical prize.");



        



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


            //Ask for guess from each player until correct answer guessed
            while (!playerWins) {
                //For-each loop through array
                for (Players c : currentPlayers) {
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

                //randomize number no longer used
                //bobBarker.randomizeNum();

                //If players play again, host enters a new phrase
                //I think I can do this by creating a new Host object and setting it under existing host variable
                bobBarker = new Hosts("Bob", "Barker");


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
