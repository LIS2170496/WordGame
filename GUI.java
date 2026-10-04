import java.awt.*;
import javax.swing.*;
//import java.awt.event.*;


public class GUI extends JFrame 
//implements ItemListener
{

    int frameWidth = 500;
    int frameHeight = 500;


    //Requirement 4b - New JLabel for list of players
    JLabel currentPlayersLabel = new JLabel("Current Players: ");

    //Requirement 4c - Button to add new player
    JButton addNewPlayerButton = new JButton("Add a New Player");

    //Requirment 4d - Label that lists the current host
    JLabel currentHostLabel = new JLabel("Current Host: ");

    //Requirement 4e - Button to open pane to enter host name and gamePhrase
    JButton openHostPhrasePaneButton = new JButton("Open Host Phrase Pane");

    //Requirement 4f - Label to display current playingPhrase with underelines
    JLabel playingPhraseLabel = new JLabel("Playing Phrase: ");

    //Requirement 4g - Button that starts the player turns when clicked
    JButton startTurnButton = new JButton("Start Turn");




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

    }

  
    
    
}
