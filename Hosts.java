public class Hosts extends Person {
    Numbers newNumber;

    public Hosts(String first, String last) {
        super(first, last);
    }

    //Instantiate Numbers.java and generate a random number
    public void randomizeNum() {
        newNumber = new Numbers();
        newNumber.generateNumber();
    }

    public Numbers getNumber() {
        return newNumber;
    }

    public boolean verifyGuess(int someGuess) {
        return newNumber.compareNumber(someGuess);
    }
}
