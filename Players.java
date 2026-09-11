//Requirement 3a - Players class extends Person
public class Players extends Person {

    //Requirement 3b - private money variable(s?)
    private int piggyBank;


    //Requirement 3d - constructor initializes $1000
    public Players() {
        piggyBank = 1000;
        System.out.println("You have $1,000 in your piggy bank");
    }


    //Requirement 3c - money field getter/setter
    public int getPiggyBank() {
        return piggyBank;
    }
    public void setPiggyBank(int numDollars) {
        piggyBank = numDollars;
    }


    //Requirement 3d - Override toString()
    @Override 
    public String toString() {
        return "Player Name: " + getFullName() + "Piggy Bank: " + getPiggyBank();
        //FIXME idk if this will work


        //System.out.println("Player Name: " + getFullName());
        //System.out.println("Piggy Bank: " + getPiggyBank());
    }


}
