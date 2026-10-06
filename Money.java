import javax.swing.JOptionPane;

public class Money implements Award {
    
    //Bet amounts moved from Players.java to Money.java
    //Variable for amount
    public static int betAmount = 10;
    public static int winAmount = betAmount * 5;


    //Implement the abstract method from Award
    public int displayWinnings(Players playerPlayers, boolean guessCorrect) {
        
        //Parameter true, win money 
        if (guessCorrect) {
            //System.out.println("Congratulations, " + playerPlayers.getFullName() + " that letter is in the phrase!");

            //Requirement 4h  -JOptionPane to give player the message of 
            // whether they were correct and/or won any prizes, 
            // how much money they currently have, etc.
            JOptionPane.showMessageDialog(null, 
                "Congratulations, " + playerPlayers.getFullName() + 
                " that letter is in the phrase!" + 
                "\nYou have won $" + winAmount);

            return winAmount;
        }

        //Parameter false, lose money
        else {
            //System.out.println("I'm sorry, " + playerPlayers.getFullName() + " that letter is not in the phrase.");
        
            //Requirement 4h  -JOptionPane to give player the message of 
            // whether they were correct and/or won any prizes, 
            // how much money they currently have, etc.
            JOptionPane.showMessageDialog(null, 
                "I'm sorry, " + playerPlayers.getFullName() + 
                " that letter is not in the phrase." + 
                "\nYou have lost $" + betAmount);
            return (betAmount * -1);
        }

    }


}
