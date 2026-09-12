import java.util.Scanner;

public class GamePlay {

    //private Person field
    //Updated to create new Person at this level 9.9.2026  
    //Requirement 7b - Person person is now a Players player
    private Players player = new Players();



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Change variables to refer to player instead of person
        String playerFirstName;
        String playerLastName;
        String nameDecision;

        //New game 9.9.2026
        GamePlay myGame = new GamePlay();


        //Requirement 7a - instantiate Host and generate random number
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
        System.out.println("Welcome, " + myGame.player.getFullName() );



        


        //Requirement 7c - removed this section
        //new Numbers instance that generates a random number
        //Numbers aRandomNumber = new Numbers();
        //aRandomNumber.generateNumber();


        //Requirement 7d - instantiate Turn
        Turn newTurn = new Turn();


        
        


        //Requirement 7e - move this prompt to takeTurn method
        //int playerGuess;
        //boolean guessCorrect = false;
        //while (!guessCorrect) {
        //    System.out.println(myGame.player.getFullName() + ", guess my random number between 0 and 100");
        //    playerGuess = scan.nextInt();
        //    guessCorrect = aRandomNumber.compareNumber(playerGuess);
        //}


        //Requirement 7f - loop to takeTurn until game over
        //while loop to play the guessing game
        boolean playerWins = false;

        while (!playerWins) {
            playerWins = newTurn.takeTurn(myGame.player, bobBarker);
        }

        


        System.out.println("Thanks for playing!");









        //Close scanner to get rid of problem alert in vscode
        scan.close(); 

    }

}
