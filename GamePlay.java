import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;

public class GamePlay extends GUI implements ActionListener{

    


    Scanner scan = new Scanner(System.in);

    //plopping GUI stuff in here instead of GUI.java
    String addPlayer1String = "Add Player1";
    String addPlayer2String = "Add Player2";
    String addPlayer3String = "Add Player3";


    //Requirement 4b - New JLabel for list of players
    JLabel currentPlayersLabel = new JLabel("Current Players: ");

    //Requirement 4c - Button to add new player
    JButton addNewPlayerButton = new JButton(addPlayer1String);

    //Requirment 4d - Label that lists the current host
    JLabel currentHostLabel = new JLabel("Current Host: ");

    //Requirement 4e - Button to open pane to enter host name and gamePhrase
    JButton openHostPhrasePaneButton = new JButton("Open Host Phrase Pane");

    //Requirement 4f - Label to display current playingPhrase with underelines
    public static JLabel playingPhraseLabel = new JLabel("Playing Phrase: ");

    //Requirement 4g - Button that starts the player turns when clicked
    JButton startGameButton = new JButton("Start Game");

    


    int dialogChoice;

    String player1FirstName;
    String player1LastName = "";
    boolean player1NameDecision;

    String player2FirstName;
    String player2LastName = "";
    boolean player2NameDecision;

    String player3FirstName;
    String player3LastName = "";
    boolean player3NameDecision;

    boolean allPlayersAdded = false;

    String hostFirstName;
    String hostLastName = "";
    String phraseToWin;




    //Gameplay variables
    //Instantiate Turn
    Turn newTurn = new Turn();
    boolean playerWins = false;
    boolean playAgain = true;
    String playAgainDecision;



    public GamePlay() {

        

        //plopping GUI stuff here instead of GUI.java

        
        add(addNewPlayerButton);
        add(currentPlayersLabel);

        add(openHostPhrasePaneButton);
        add(currentHostLabel);
        

        add(playingPhraseLabel);

        add(startGameButton);

        

        openHostPhrasePaneButton.setEnabled(false);
        openHostPhrasePaneButton.setVisible(false);

        startGameButton.setEnabled(false);
        startGameButton.setVisible(false);

        //Requirement ??
        addNewPlayerButton.addActionListener(this);
        openHostPhrasePaneButton.addActionListener(this);
        startGameButton.addActionListener(this);

        
    }



    @Override
    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();


        //IF Add Player button was pressed
        if(source == addNewPlayerButton) {
        
            //Adding Player1
            if (addPlayer1String.equals(addNewPlayerButton.getText())) {
                player1FirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
                
                //Requirement 4b - Set JLabel to list current players
                currentPlayersLabel.setText(currentPlayersLabel.getText() + player1FirstName);

                dialogChoice = JOptionPane.showConfirmDialog(
                    null, 
                    "Add last name?",
                    "Select an Option",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

                player1NameDecision = (dialogChoice == JOptionPane.YES_OPTION);

                if (player1NameDecision) {
                    player1LastName = JOptionPane.showInputDialog(null, "Enter your last name: ");

                    //Requirement 4b - Set JLabel to list current players
                    currentPlayersLabel.setText(currentPlayersLabel.getText() + " " + player1LastName);
                }
                GamePlay.addNewPlayer(0, player1FirstName, player1LastName);
                
                addNewPlayerButton.setText(addPlayer2String);
            }

            //Adding Player2
            else if (addPlayer2String.equals(addNewPlayerButton.getText())) {
                player2FirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");

                //Requirement 4b - Set JLabel to list current players
                currentPlayersLabel.setText(currentPlayersLabel.getText() + ", " + player2FirstName);

                dialogChoice = JOptionPane.showConfirmDialog(
                    null, 
                    "Add last name?",
                    "Select an Option",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                player2NameDecision = (dialogChoice == JOptionPane.YES_OPTION);
                if (player2NameDecision) {
                    player2LastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
                    //Requirement 4b - Set JLabel to list current players
                    currentPlayersLabel.setText(currentPlayersLabel.getText() + " " + player2LastName);
                }
                GamePlay.addNewPlayer(1, player2FirstName, player2LastName);
                addNewPlayerButton.setText(addPlayer3String);
            }

            //Adding Player3
            else if (addPlayer3String.equals(addNewPlayerButton.getText())) {
                player3FirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
                //Requirement 4b - Set JLabel to list current players
                currentPlayersLabel.setText(currentPlayersLabel.getText() + ", " + player3FirstName);

                dialogChoice = JOptionPane.showConfirmDialog(
                    null, 
                    "Add last name?",
                    "Select an Option",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                player3NameDecision = (dialogChoice == JOptionPane.YES_OPTION);
                if (player3NameDecision) {
                    player3LastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
                    //Requirement 4b - Set JLabel to list current players
                    currentPlayersLabel.setText(currentPlayersLabel.getText() + " " + player3LastName);
                }
                GamePlay.addNewPlayer(2, player3FirstName, player3LastName);
                allPlayersAdded = true;
                addNewPlayerButton.setEnabled(false);
                addNewPlayerButton.setVisible(false);

                openHostPhrasePaneButton.setEnabled(true);
                openHostPhrasePaneButton.setVisible(true);
            }

            //extra else
            else {
                System.out.println("Problem in GUI class at ActionPerformed on Add Player button");
            }

        }


        //IF Open Host Phrase Pane button was pressed
        if(source == openHostPhrasePaneButton) {
            hostFirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");

            dialogChoice = JOptionPane.showConfirmDialog(
                    null, 
                    "Add last name?",
                    "Select an Option",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            
            if(dialogChoice == JOptionPane.YES_OPTION) {
                hostLastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
            }
            else {
                hostLastName = "";
            }
            
            phraseToWin = JOptionPane.showInputDialog(null, "Enter the winning phrase: ");

           
            GamePlay.addNewHost(hostFirstName, hostLastName, phraseToWin);
            
            
            //Requirement 4d - Set JLavel to display current host full name
            currentHostLabel.setText(currentHostLabel.getText() + hostFirstName + " " + hostLastName);
            playingPhraseLabel.setText("Playing Phrase: " + currentHost.winningPhrase.playingPhraseStringBuilder);
            openHostPhrasePaneButton.setEnabled(false);
            openHostPhrasePaneButton.setVisible(false);

            

            startGameButton.setEnabled(true);
            startGameButton.setVisible(true);

        }

        if(source == startGameButton) {
            //System.out.println("You each have $1,000 in your piggy bank");
            JOptionPane.showMessageDialog(null,"You each have $1,000 in your piggy bank");


            //Now guessing incorrectly on a possible Physical prize loses $0 instead of $10?
            //System.out.println("Each guess will bet $" + Money.betAmount);
            //System.out.println("If you guess correctly, you will win $" + Money.winAmount + " or a random physical prize.");
            JOptionPane.showMessageDialog(null,
                "If you guess correctly, you will win $" + 
                Money.winAmount + 
                " or a random physical prize.");

            




            //Loop to takeTurn until game over (what about if ran out of money)
        
            //Outer loop for playAgain option
            while (playAgain) {
                playerWins = false;
                playAgainDecision = "";

                //while loop to play the guessing game
                //Ask for guess from each player until correct answer guessed
                while (!playerWins) {
                    //For-each loop through array

                    
                    

                    for (Players c : currentPlayers) {
                        playerWins = newTurn.takeTurn(c, currentHost);

                        //to get out after number guessed correctly
                        if (playerWins) {
                            break;
                        }
                    }
                }

            
                //prevent invalid entry
                while (!playAgainDecision.equals("Y")  &&  !playAgainDecision.equals("N")) {
                    //System.out.println("\nWould you like to play again? (Y / N)");
                    //playAgainDecision = scan.nextLine();

                    dialogChoice = JOptionPane.showConfirmDialog(
                        null, 
                        "Would you like to play again?",
                        "Select an Option",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            
                    if(dialogChoice == JOptionPane.YES_OPTION) {
                        playAgainDecision = "Y";
                        playAgain = true;
                        //currentHost = new Hosts(currentHost.getFirstName(), currentHost.getLastName());
                    }
                    else {
                        playAgainDecision = "N";
                        //System.out.println("Thanks for playing!");
                        playAgain = false;
                        JOptionPane.showMessageDialog(null,"Thanks for playing!");
                    }
                }
            }
        }
    }















    public static Players[] currentPlayers = new Players[3];

    public static void addNewPlayer(int i, String fname, String lname) {
        //Player creation now part of new method
        currentPlayers[i] = new Players();
        currentPlayers[i].setFirstName(fname);
        currentPlayers[i].setLastName(lname);
    }

    public static Hosts currentHost;


    public static void addNewHost(String fname, String lname, String a) {
        currentHost = new Hosts(fname, lname);
        Phrases currentHostsPhrase = new Phrases(a);
        currentHost.winningPhrase = currentHostsPhrase;
    }

    public static void setPlayingPhraseLabel() {
        playingPhraseLabel.setText("Playing Phrase: " + currentHost.winningPhrase.playingPhraseStringBuilder);
    }






    public static void main(String[] args) {
        GamePlay myGame = new GamePlay();

    }


}
