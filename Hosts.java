public class Hosts extends Person {
    Numbers newNumber;

    public Hosts(String first, String last) {
        super(first, last);
    }

    //Requirement 5a - instantiate Numbers.java and generate a random number
    public void randomizeNum() {
        Numbers newNumber = new Numbers();
        newNumber.generateNumber();
    }

    public Numbers getNumber() {
        return newNumber;
    }

    public boolean verifyGuess(int someGuess) {
        return newNumber.compareNumber(someGuess);
    }
}
