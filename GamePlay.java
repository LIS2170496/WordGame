import java.util.Scanner;

public class GamePlay {

    //private Person field
    //Updated to create new Person at this level 9.9.2026  
    private Person person = new Person();



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String personFirstName;
        String personLastName;
        String nameDecision;

        //New game 9.9.2026
        GamePlay myGame = new GamePlay();


        //ask for person's name in main
        System.out.println("Player 1, enter your first name: ");
        personFirstName = scan.nextLine();

        //ask if they want to add last name
        System.out.println("Would you like to add your last name? (Y / N)");
        nameDecision = scan.nextLine();
        

        //prevent invalid entry
        while (!nameDecision.equals("Y")  &&  !nameDecision.equals("N")) {
            System.out.println("Would you like to add your last name? (Y / N)");
            nameDecision = scan.nextLine();
        }


        
        //Instance of Person depending on fname or fname+lname
        //Updated player1 to myGame.person  9.9.2026
        if (nameDecision.equals("Y")) {
            System.out.println("Enter your last name: ");
            personLastName = scan.nextLine();
            myGame.person.setFirstName(personFirstName);
            myGame.person.setLastName(personLastName);
        }
        else {
            myGame.person.setFirstName(personFirstName);
        }
        

        //Welcome message to confirm what is stored in Person object
        //Updated player1 to myGame.person  9.9.2026
        System.out.println("Welcome, " + myGame.person.getFullName() );


        //new Numbers instance that generates a random number
        Numbers aRandomNumber = new Numbers();
        aRandomNumber.generateNumber();

        //while loop to play the guessing game
        int playerGuess;
        boolean guessCorrect = false;

        while (!guessCorrect) {
            System.out.println(myGame.person.getFullName() + ", guess my random number between 0 and 100");
            playerGuess = scan.nextInt();
            guessCorrect = aRandomNumber.compareNumber(playerGuess);
        }


        System.out.println("Thanks for playing!");









        //Close scanner to get rid of problem alert in vscode
        scan.close(); 

    }

}
