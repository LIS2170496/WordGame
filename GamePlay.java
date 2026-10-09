import javax.swing.*;
import java.awt.event.*;

//main application uses GUI as exension of JFrame
public class GamePlay extends GUI implements ActionListener{

    
    int dialogChoice;

    String player1FirstName = "";
    String player1LastName = "";
    boolean player1NameDecision;

    String player2FirstName = "";
    String player2LastName = "";
    boolean player2NameDecision;

    String player3FirstName = "";
    String player3LastName = "";
    boolean player3NameDecision;

    boolean allPlayersAdded = false;

    String hostFirstName = "";
    String hostLastName = "";
    String phraseToWin = "";

    




    //Gameplay variables
    //Instantiate Turn
    Turn newTurn = new Turn();
    boolean playerWins = false;
    boolean playAgain = true;
    String playAgainDecision;




    public GamePlay() {

        super();

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
                while (player1FirstName == null  ||  player1FirstName.equals("")) {
                    player1FirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");

                    if (player1FirstName == null) {
                        return;
                    }
                }
                
                //Set JLabel to list current players
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

                    if (player1LastName == null) {
                        player1LastName = "";
                    }

                    //Set JLabel to list current players
                    currentPlayersLabel.setText(currentPlayersLabel.getText() + " " + player1LastName);
                }
                GamePlay.addNewPlayer(0, player1FirstName, player1LastName);
                
                addNewPlayerButton.setText(addPlayer2String);
            }

            //Adding Player2
            else if (addPlayer2String.equals(addNewPlayerButton.getText())) {
                while (player2FirstName == null  ||  player2FirstName.equals("")) {
                    player2FirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");

                    if (player2FirstName == null) {
                        return;
                    }
                }

                //Set JLabel to list current players
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
                    if (player2LastName == null) {
                        player2LastName = "";
                    }
                    //Set JLabel to list current players
                    currentPlayersLabel.setText(currentPlayersLabel.getText() + " " + player2LastName);
                }
                GamePlay.addNewPlayer(1, player2FirstName, player2LastName);
                addNewPlayerButton.setText(addPlayer3String);
            }

            //Adding Player3
            else if (addPlayer3String.equals(addNewPlayerButton.getText())) {
                while (player3FirstName == null  ||  player3FirstName.equals("")) {
                    player3FirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");

                    if (player3FirstName == null) {
                        return;
                    }
                }

                //Set JLabel to list current players
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
                    if (player3LastName == null) {
                        player3LastName = "";
                    }
                    //Set JLabel to list current players
                    currentPlayersLabel.setText(currentPlayersLabel.getText() + " " + player3LastName);
                }
                GamePlay.addNewPlayer(2, player3FirstName, player3LastName);
                allPlayersAdded = true;
                addNewPlayerButton.setEnabled(false);
                addNewPlayerButton.setVisible(false);

                openHostPhrasePaneButton.setEnabled(true);
                openHostPhrasePaneButton.setVisible(true);
            }

            else {
                JOptionPane.showMessageDialog(null,
                    "Problem in GUI class at ActionPerformed on Add Player button");
            }

        }


        //IF Open Host Phrase Pane button was pressed
        if(source == openHostPhrasePaneButton) {
            while (hostFirstName == null  ||  hostFirstName.equals("")) {
                hostFirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");

                if (hostFirstName == null) {
                    return;
                }
            }

            dialogChoice = JOptionPane.showConfirmDialog(
                    null, 
                    "Add last name?",
                    "Select an Option",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            
            if(dialogChoice == JOptionPane.YES_OPTION) {
                hostLastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
                if (hostLastName == null) {
                        hostLastName = "";
                    }
            }
            else {
                hostLastName = "";
            }
            
            while (phraseToWin == null  || phraseToWin.equals("")) {
                phraseToWin = JOptionPane.showInputDialog(null, "Enter the winning phrase: ");

                if (phraseToWin == null) {
                    return;
                }
            }

           
            GamePlay.addNewHost(hostFirstName, hostLastName, phraseToWin);
            
            
            //Set JLavel to display current host full name
            currentHostLabel.setText(currentHostLabel.getText() + hostFirstName + " " + hostLastName);
            //Set JLabel to display playingPhrase
            playingPhraseLabel.setText("Playing Phrase: " + currentHost.winningPhrase.playingPhraseStringBuilder);
            openHostPhrasePaneButton.setEnabled(false);
            openHostPhrasePaneButton.setVisible(false);

            

            startGameButton.setEnabled(true);
            startGameButton.setVisible(true);

        }

        if(source == startGameButton) {

            //Button that starts the player turns when clicked

            if (currentHost == null) {
                JOptionPane.showMessageDialog(null,"Cannot play without a host!");
            }

            else if (currentPlayers[0] == null) {
                JOptionPane.showMessageDialog(null,"Cannot play without Player1!");
            }
            else if (currentPlayers[1] == null) {
                JOptionPane.showMessageDialog(null,"Cannot play without Player2!");
            }
            else if (currentPlayers[2] == null) {
                JOptionPane.showMessageDialog(null,"Cannot play without Player3!");
            }
            else if (phraseToWin == null  ||  phraseToWin.equals("")) {
                JOptionPane.showMessageDialog(null,"Cannot play without a winning phrase!");
            }

            else {

                startGameButton.setEnabled(false);
                startGameButton.setVisible(false);

                JOptionPane.showMessageDialog(null,"You each have $1,000 in your piggy bank");


                //guessing incorrectly on a possible Physical prize loses $0 instead of $10?
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

                        //JOptionPane with Yes/No to let the user decide if they want to play again
                        dialogChoice = JOptionPane.showConfirmDialog(
                            null, 
                            "Would you like to play again?",
                            "Select an Option",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                
                        if(dialogChoice == JOptionPane.YES_OPTION) {
                            playAgainDecision = "Y";
                            playAgain = true;

                            phraseToWin = null;
                            openHostPhrasePaneButton.setEnabled(true);
                            openHostPhrasePaneButton.setVisible(true);

                            while (phraseToWin == null  || phraseToWin.equals("")) {
                                phraseToWin = JOptionPane.showInputDialog(null, "Enter the winning phrase: ");

                                if (phraseToWin == null) {
                                    return;
                                }
                            }
                            
                            GamePlay.addNewHost(hostFirstName, hostLastName, phraseToWin);
                            //Set JLabel to display playingPhrase
                            playingPhraseLabel.setText("Playing Phrase: " + currentHost.winningPhrase.playingPhraseStringBuilder);
                            openHostPhrasePaneButton.setEnabled(false);
                            openHostPhrasePaneButton.setVisible(false);


                        }
                        else {
                            playAgainDecision = "N";
                            playAgain = false;
                            JOptionPane.showMessageDialog(null,"Thanks for playing!");
                        }
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
        //Set JLabel to display playingPhrase
        playingPhraseLabel.setText("Playing Phrase: " + currentHost.winningPhrase.playingPhraseStringBuilder);
    }






    public static void main(String[] args) {
        GamePlay myGame = new GamePlay();
        myGame.setVisible(true);

    }


}
