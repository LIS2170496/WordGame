import java.util.Random;

public class Physical implements Award {
    
    //Requirement 6a - String array of 5 prizes
    String[] prizes = {
        "new car", 
        "Hawaii vacation", 
        "flat screen TV", 
        "lifetime supply of ice cream", 
        "one-year movie theater membership"
    };

    //Requirement 6b - generate random number to assign prize
    public int getRandomPrize() {
        int randomPrize;

        Random random = new Random();

        //Bound 5 creates random int 0, 1, 2, 3, or 4
        randomPrize = random.nextInt(5);

        return randomPrize;
    }




    //Requirement 6c - Implement the abstract method from Award
    public int displayWinnings(Players playerPlayers, boolean guessCorrect) {

        //Requirement 6c.i - parameter true, win a prize
        if (guessCorrect) {
            System.out.println("Congratulations, " + playerPlayers.getFullName() + " you guessed the number!");
            System.out.println("You have won a " + prizes[getRandomPrize()] + "!");
            return 0;
        }

        //Requirement 6c.ii - parameter false, win nothing
        else {
            System.out.println("I'm sorry, " + playerPlayers.getFullName() + " you did not guess the number.");
            System.out.println("You could have won a " + prizes[getRandomPrize()] + ".");
            return 0;
        }
    }






}