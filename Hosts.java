public class Hosts extends Person {
    Numbers newNumber;

    //Requirement 5a - instantiate Numbers.java and generate a random number
    public void randomizeNum() {
        Numbers newNumber = new Numbers();
        newNumber.generateNumber();
    }

    public Numbers getNumber() {
        return newNumber;
    }
}
