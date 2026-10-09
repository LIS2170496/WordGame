import java.awt.*;
import javax.swing.*;

//Requirement 4a - new GUI.java class
public class GUI extends JFrame {

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
    public static JLabel playingPhraseLabel = new JLabel("Playing Phrase: ");

    //Requirement 4g - Button that starts the player turns when clicked
    JButton startGameButton = new JButton("Start Game");




    public GUI () {

        super("Wheel of Wonder");

        setSize(frameWidth, frameHeight);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());



        
        add(addNewPlayerButton);
        add(currentPlayersLabel);

        add(openHostPhrasePaneButton);
        add(currentHostLabel);
        
        add(playingPhraseLabel);

        add(startGameButton);

        setVisible(true);


        openHostPhrasePaneButton.setEnabled(false);
        openHostPhrasePaneButton.setVisible(false);

        startGameButton.setEnabled(false);
        startGameButton.setVisible(false);







    }

    
    
}
