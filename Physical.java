import java.util.Random;

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

            //Text area message to give player the message of 
            // whether they were correct and/or won any prizes, 
            // how much money they currently have, etc.
            GamePlay.setTextArea(
                "\n\nCongratulations, " + playerPlayers.getFullName() + ", that letter is in the phrase!" + 
                "\nYou have won a " + prizes[getRandomPrize()] + "!");
            GamePlay.textArea.setCaretPosition(GamePlay.textArea.getDocument().getLength());
            return 0;
        }

        //Parameter false, win nothing
        else {

            //Text area message to give player the message of 
            // whether they were correct and/or won any prizes, 
            // how much money they currently have, etc.
            GamePlay.setTextArea(
                "\n\nI'm sorry, " + playerPlayers.getFullName() + ", that letter is not in the phrase." + 
                "\nYou could have won a " + prizes[getRandomPrize()] + ".");
            GamePlay.textArea.setCaretPosition(GamePlay.textArea.getDocument().getLength());
            return 0;
        }
    }






}