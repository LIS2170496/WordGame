import java.util.Random;

import javax.swing.JOptionPane;

public class Physical implements Award {
    
    //String array of 5 prizes
    String[] prizes = {
        "new car", 
        "Hawaii vacation", 
        "flat screen TV", 
        "lifetime supply of ice cream", 
        "one-year movie theater membership",
        "fruit basket",
        "golden ticket"
    };

    //Generate random number to assign prize
    public int getRandomPrize() {
        int randomPrize;

        Random random = new Random();

        //Bound 5 creates random int 0, 1, 2, 3, or 4
        randomPrize = random.nextInt(5);

        return randomPrize;
    }




    //Implement the abstract method from Award
    public int displayWinnings(Players playerPlayers, boolean guessCorrect) {

        //Parameter true, win a prize
        if (guessCorrect) {
            //System.out.println("Congratulations, " + playerPlayers.getFullName() + " that letter is in the phrase!");
            //System.out.println("You have won a " + prizes[getRandomPrize()] + "!");
            JOptionPane.showMessageDialog(null,
                "Congratulations, " + playerPlayers.getFullName() + " that letter is in the phrase!" + 
                "\nYou have won a " + prizes[getRandomPrize()] + "!");
            return 0;
        }

        //Parameter false, win nothing
        else {
            //System.out.println("I'm sorry, " + playerPlayers.getFullName() + " that letter is not in the phrase.");
            //System.out.println("You could have won a " + prizes[getRandomPrize()] + ".");
            JOptionPane.showMessageDialog(null,
                "I'm sorry, " + playerPlayers.getFullName() + " that letter is not in the phrase." + 
                "\nYou could have won a " + prizes[getRandomPrize()] + ".");
            return 0;
        }
    }






}