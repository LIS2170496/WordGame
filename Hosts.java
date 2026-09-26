public class Hosts extends Person {
    //Numbers newNumber;

    public Hosts(String first, String last) {
        super(first, last);
    }

    //Requirement 6a - This method will no longer be used
    //Instantiate Numbers.java and generate a random number
    //public void randomizeNum() {
    //    newNumber = new Numbers();
    //    newNumber.generateNumber();
    //}

    //Requirement 6a - This method will no longer be used
    //public Numbers getNumber() {
    //    return newNumber;
    //}

    //Requirement 6a - This method will no longer be used
    //public boolean verifyGuess(int someGuess) {
    //    return newNumber.compareNumber(someGuess);
    //}

    //Requirement 6a - Send Host's chosen phrase to Phrases.java
    public void sendPhrase(String gamePhrase) {
        Phrases playingPhrase = new Phrases(gamePhrase);
    }



}
