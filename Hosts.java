import java.util.Scanner;

public class Hosts extends Person {
    //Numbers newNumber;

    public Hosts(String first, String last) {
        super(first, last);

        //Requirement 7a - Upon instantiation, host will enter a phrase for
        //                 players to guess. This instantiates Phrases.java
        Scanner scan = new Scanner(System.in);
        System.out.println("Host, please enter a phrase for the players to guess: ");
        Phrases winningPhrase = new Phrases(scan.nextLine());
        //Close scanner to get rid of problem alert in vscode
        scan.close(); 
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
