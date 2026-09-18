public class Money implements Award {
    
    //Requirement 5a - Bet amounts moved from Players.java to Money.java
    //Variable for amount
    public static int betAmount = 10;
    public static int winAmount = betAmount * 5;


    //Requirement 5b - Implement the abstract method from Award
    public int displayWinnings(Players playerPlayers, boolean guessCorrect) {
        
        //Requirement 5b.i - parameter true, win money 
        if (guessCorrect) {
            System.out.println("Congratulations, " + playerPlayers.getFullName() + " you guessed the number!");
            return winAmount;
        }

        //Requirement 5b.ii - parameter false, lose money
        else {
            System.out.println("I'm sorry, " + playerPlayers.getFullName() + " you did not guess the number.");
            return (betAmount * -1);
        }

    }


}
