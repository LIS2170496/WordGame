//Requirement 3a - Players class extends Person
public class Players extends Person {

    //Requirement 3b - private money variable
    private int piggyBank;

    //Requirement 6a.vi - variable for amount
    public int betAmount = 10;
    public int winAmount = betAmount * 5;


    //Requirement 3d - constructor initializes $1000
    public Players() {
        piggyBank = 1000;
        System.out.println("Welcome!");
    }


    //Requirement 3c - money field getter/setter
    public int getPiggyBank() {
        return piggyBank;
    }
    public void setPiggyBank(int numDollars) {
        piggyBank = numDollars;
    }


    //Requirement 3e - Override toString()
    @Override 
    public String toString() {
        return "Player Name: " + getFullName() + "     Piggy Bank: " + getPiggyBank();
    }


}
