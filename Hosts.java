import java.util.InputMismatchException;
import java.util.Scanner;

public class Hosts extends Person {
    Phrases winningPhrase;

    public Hosts(String first, String last) {
        super(first, last);

        //Upon instantiation, host will enter a phrase for
        //                 players to guess. This instantiates Phrases.java
        Scanner scan = new Scanner(System.in);
        System.out.println("Host, please enter a phrase for the players to guess: ");
        winningPhrase = new Phrases(scan.nextLine());
        
    }



    //This method will no longer be used
    //Instantiate Numbers.java and generate a random number
    //public void randomizeNum() {
    //    newNumber = new Numbers();
    //    newNumber.generateNumber();
    //}

    //This method will no longer be used
    //public Numbers getNumber() {
    //    return newNumber;
    //}

    //This method will no longer be used
    //public boolean verifyGuess(int someGuess) {
    //    return newNumber.compareNumber(someGuess);
    //}

    //Send Host's chosen phrase to Phrases.java
    //in between method for Try/Catch block for findLetters
    public boolean sendPhrase(String gamePhrase) throws MultipleLettersException, InputMismatchException {

        if (winningPhrase.findLetters(gamePhrase)) {
            return true;
        }
        else {
            return false;
        }
        
    }

    //Add method to see if phrase has been solved
    public boolean phraseSolved() {
        return winningPhrase.phraseSolved;
    }

    

    


}

