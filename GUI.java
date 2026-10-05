import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class GUI extends JFrame implements ActionListener{

    int frameWidth = 500;
    int frameHeight = 500;

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
    JLabel playingPhraseLabel = new JLabel("Playing Phrase: ");

    //Requirement 4g - Button that starts the player turns when clicked
    JButton startTurnButton = new JButton("Start Turn");

    int dialogChoice;

    String player1FirstName;
    String player1LastName;
    boolean player1NameDecision;

    String player2FirstName;
    String player2LastName;
    boolean player2NameDecision;

    String player3FirstName;
    String player3LastName;
    boolean player3NameDecision;

    boolean allPlayersAdded = false;




    public GUI () {

        super("Wheel of Wonder");

        setSize(frameWidth, frameHeight);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        add(currentPlayersLabel);
        add(addNewPlayerButton);
        add(currentHostLabel);
        add(openHostPhrasePaneButton);
        add(playingPhraseLabel);
        add(startTurnButton);


        //Requirement 
        addNewPlayerButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();


        //IF Add Player button was pressed
        if(source == addNewPlayerButton) {
        
            //Adding Player1
            if (addPlayer1String.equals(addNewPlayerButton.getText())) {
                player1FirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
                dialogChoice = JOptionPane.showConfirmDialog(
                    null, 
                    "Add last name?",
                    "Select an Option",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                player1NameDecision = (dialogChoice == JOptionPane.YES_OPTION);
                if (player1NameDecision) {
                    player1LastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
                }
                addNewPlayerButton.setText(addPlayer2String);
            }

            //Adding Player2
            else if (addPlayer2String.equals(addNewPlayerButton.getText())) {
                player2FirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
                dialogChoice = JOptionPane.showConfirmDialog(
                    null, 
                    "Add last name?",
                    "Select an Option",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                player2NameDecision = (dialogChoice == JOptionPane.YES_OPTION);
                if (player2NameDecision) {
                    player2LastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
                }
                addNewPlayerButton.setText(addPlayer3String);
            }

            //Adding Player3
            else if (addPlayer3String.equals(addNewPlayerButton.getText())) {
                player3FirstName = JOptionPane.showInputDialog(null, "Enter your first name: ");
                dialogChoice = JOptionPane.showConfirmDialog(
                    null, 
                    "Add last name?",
                    "Select an Option",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                player3NameDecision = (dialogChoice == JOptionPane.YES_OPTION);
                if (player3NameDecision) {
                    player3LastName = JOptionPane.showInputDialog(null, "Enter your last name: ");
                }
                allPlayersAdded = true;
                addNewPlayerButton.setEnabled(false);
                //addNewPlayerButton.setVisible(false);
            }

            //extra else
            else {
                System.out.println("Problem in GUI class at ActionPerformed on Add Player button");
            }

        }

    }

  
    
    
}
