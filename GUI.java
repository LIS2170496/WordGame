import java.awt.*;
import javax.swing.*;
//import java.awt.event.*;


public class GUI extends JFrame 
//implements ItemListener
{

    int frameWidth = 500;
    int frameHeight = 500;

    public GUI () {

        super("Wheel of Wonder");

        


        setSize(frameWidth, frameHeight);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //Requirement 4b - New JLabel for list of players
        JLabel currentPlayers = new JLabel("Current Players: ");

        //Requirement 4c - Button to add new player
        JButton addNewPlayer = new JButton("Add a New Player");

        //Requirment 4d - Label that lists the current host
        JLabel currentHost = new JLabel("Current Host: ");

        //Requirement 4e - Button to open pane to enter host name and gamePhrase
        JButton openHostPhrasePane = new JButton("Open Host Phrase Pane");

        //Requirement 4f - Label to display current playingPhrase with underelines
        JLabel playingPhraseLabel = new JLabel("Playing Phrase: ");

        //Requirement 4g - Button that starts the player turns when clicked
        JButton startTurn = new JButton("Start Turn");

        setLayout(new FlowLayout());

        add(currentPlayers);
        add(addNewPlayer);
        add(currentHost);
        add(openHostPhrasePane);
        add(playingPhraseLabel);
        add(startTurn);

    }

  
    
    
}
