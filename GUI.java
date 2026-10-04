import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class GUI extends JFrame implements ItemListener{

    //Requirement 4a - New JFrame
    JFrame gameWindow = new JFrame("gameWindow Title");

    //Requirement 4b - New JLabel for list of players
    JLabel currentPlayers = new JLabel();

    //Requirement 4c - Button to add new player
    JButton addNewPlayer = new JButton();

    //Requirment 4d - Label that lists the current host
    JLabel currentHost = new JLabel();

    //Requirement 4e - Button to open pane to enter host name and gamePhrase
    JButton openHostPhrasePane = new JButton();

    //Requirement 4f - Label to display current playingPhrase with underelines
    JLabel playingPhraseLabel = new JLabel();

    //Requirement 4g - Button that starts the player turns when clicked
    JButton startTurn = new JButton();

  
    
    
}
