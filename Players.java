//Players class extends Person
public class Players extends Person {

    //Private money variable
    private int piggyBank;



    //Constructor initializes $1000
    public Players() {
        piggyBank = 1000;
        System.out.println("Welcome!");
    }


    //Money field getter/setter
    public int getPiggyBank() {
        return piggyBank;
    }
    public void setPiggyBank(int numDollars) {
        piggyBank = numDollars;
    }


    //Override toString()
    @Override 
    public String toString() {
        return "Player Name: " + getFullName() + "     Piggy Bank: " + getPiggyBank();
    }


}
