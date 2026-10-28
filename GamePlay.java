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

        
        addPlayerMenuItem.addActionListener(this);
        addHostMenuItem.addActionListener(this);
        layoutMenuItem.addActionListener(this);
        attributionMenuItem.addActionListener(this);

        
    }



    @Override
    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();

        //When this menu item is clicked, create a popup message that 
        // describes why you chose the particular layout you chose for your application.
        if(source == layoutMenuItem) {
            JOptionPane.showMessageDialog(null, 
                "I chose a null layout for the main frame and " + 
                "\nFlowLayout.LEFT for each panel in the frame. " + 
                "\nThis allowed me to line up each panel where I " + 
                "\nwanted it and then the content within each panel " + 
                "\nis aligned to the left side of the panel."
            );
        }

        //LESSON10
        if(source == attributionMenuItem) {
            JOptionPane.showMessageDialog(null, 
                "New Car" + 
                "\nhttps://cdn.pixabay.com/photo/2020/05/19/10/05/opel-5190050_1280.jpg" + 
                "\n" + 
                "\nHawaii Vacation" + 
                "\nhttps://media.istockphoto.com/id/117211856/photo/where-coconuts-grow.jpg" + 
                "\n" + 
                "\nFlat Screen TV" + 
                "\nhttps://media.istockphoto.com/id/1395191574/photo/black-led-tv-television-screen-blank-isolated.jpg" + 
                "\n" + 
                "\nLifetime Supply of Ice Cream" + 
                "\nhttps://media.istockphoto.com/id/2153490093/photo/three-glasses-of-ice-cream-with-balls-decorated-on-table.jpg" + 
                "\n" + 
                "\nOne-Year Movie Theater Membership" + 
                "\nhttps://cdn.pixabay.com/photo/2024/06/23/20/54/ai-generated-8848753_1280.jpg" + 
                "\n" + 
                "\nFruit Basket" + 
                "\nhttps://cdn.pixabay.com/photo/2018/05/14/12/31/fruit-3399834_1280.jpg" + 
                "\n" + 
                "\nGolden Ticket" + 
                "\nhttps://cdn.pixabay.com/photo/2017/08/06/04/06/gold-2588578_1280.jpg"
            );
        }



        //This is now a menu Item with action listener
        //IF Add Player menu option was pressed
        if(source == addPlayerMenuItem) {
        
            //Adding Player1
            if (addPlayer1String.equals(addPlayerMenuItem.getText())) {
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
                
                
                addPlayerMenuItem.setText(addPlayer2String);


                setTextArea("\nOpen the Game menu to add Player 2");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }

            //Adding Player2
            else if (addPlayer2String.equals(addPlayerMenuItem.getText())) {
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
                addPlayerMenuItem.setText(addPlayer3String);


                setTextArea("\nOpen the Game menu to add Player 3");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }

            //Adding Player3
            else if (addPlayer3String.equals(addPlayerMenuItem.getText())) {
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
                addPlayerMenuItem.setEnabled(false);
                addPlayerMenuItem.setVisible(false);

                addHostMenuItem.setEnabled(true);
                addHostMenuItem.setVisible(true);

                setTextArea("\nOpen the Game menu to add a host");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }

            else {
                JOptionPane.showMessageDialog(null,
                    "Problem in GUI class at ActionPerformed on Add Player button");
            }

        }

        //This is now a menu Item with action listener
        //IF Open Host Phrase Pane menu option was pressed
        if(source == addHostMenuItem) {
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
            addHostMenuItem.setEnabled(false);
            addHostMenuItem.setVisible(false);

            
            textArea.setText("");
            startGameButton.setEnabled(true);
            startGameButton.setVisible(true);

        }

        if(source == startGameButton) {

            //Button that starts the player turns when clicked

            if (currentHost == null) {
                setTextArea("\nCannot play without a host!");
            }

            else if (currentPlayers[0] == null) {
                setTextArea("\nCannot play without Player1!");
            }
            else if (currentPlayers[1] == null) {
                setTextArea("\nCannot play without Player2!");
            }
            else if (currentPlayers[2] == null) {
                setTextArea("\nCannot play without Player3!");
            }
            else if (phraseToWin == null  ||  phraseToWin.equals("")) {
                setTextArea("\nCannot play without a winning phrase!");
            }

            else {

                startGameButton.setEnabled(false);
                startGameButton.setVisible(false);

                //guessing incorrectly on a possible Physical prize loses $0 instead of $10?
                setTextArea(
                    "\n\nWelcome, players!" + 
                    "\nYou each have $1,000 in your piggy bank" + 
                    "\n" + 
                    "If you guess correctly, you will win $" + 
                    Money.winAmount + 
                    " or a random physical prize.");
                textArea.setCaretPosition(textArea.getDocument().getLength());

                




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

                                //This message is appended to the textArea instead of using
                                // the setTextArea method so that the player can read it.
                                //If the setTextArea were used at this point, the messages
                                // from the player's toString method and the messages
                                // from the Money or Physical prize class would be overridden
                                // too quickly for the player to read it.
                                GamePlay.textArea.append("\n\nYou won! Answer: " + currentHost.winningPhrase.getPlayingPhrase());
                                GamePlay.textArea.setCaretPosition(GamePlay.textArea.getDocument().getLength());
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
                            addHostMenuItem.setEnabled(true);
                            addHostMenuItem.setVisible(true);

                            while (phraseToWin == null  || phraseToWin.equals("")) {
                                phraseToWin = JOptionPane.showInputDialog(null, "Enter the winning phrase: ");

                                if (phraseToWin == null) {
                                    return;
                                }
                            }
                            textArea.setText("");
                            GamePlay.addNewHost(hostFirstName, hostLastName, phraseToWin);
                            //Set JLabel to display playingPhrase
                            playingPhraseLabel.setText("Playing Phrase: " + currentHost.winningPhrase.playingPhraseStringBuilder);
                            addHostMenuItem.setEnabled(false);
                            addHostMenuItem.setVisible(false);


                        }
                        else {
                            playAgainDecision = "N";
                            playAgain = false;
                            JOptionPane.showMessageDialog(null,"Thanks for playing!");
                            System.exit(0);
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

        //open frame in center of screen
        myGame.setLocationRelativeTo(null);

    }


}
