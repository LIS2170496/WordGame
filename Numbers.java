import java.util.Random;

public class Numbers {

    //Requirement 4a - private integer randomNum
    private int randomNum;

    //Requirement 4a - public getters and setters for randNum
    public void setRandomNumber(int r) {
        randomNum = r;
    }
    public int getRandomNumber() {
        return randomNum;
    }


    //Requirement 4b - generate int between 0 and 100 then set on randomNum
    public void generateNumber() {
        Random random = new Random();
        randomNum = random.nextInt(101);
    }


    //Requirement 4c - method to compare guess to answer then return statement and boolean
    public boolean compareNumber(int guess) {
        if (guess == randomNum) {
            System.out.println("Congratulations, you guessed the number!");
            return true;
        }

        else if (guess > randomNum) {
            System.out.println("I'm sorry.  That guess was too high.");
            return false;
        }

        else if (guess < randomNum) {
            System.out.println("I'm sorry, That guess was too low.");
            return false;
        }

        else {
            System.out.println("I'm sorry, there was a problem.");
            return false;
        }


    }






}
