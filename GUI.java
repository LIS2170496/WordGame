import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {

    int frameWidth = 500;
    int frameHeight = 500;

    String addPlayer1String = "Add Player1";
    String addPlayer2String = "Add Player2";
    String addPlayer3String = "Add Player3";

    JLabel currentPlayersLabel = new JLabel("Current Players: ");
    JButton addNewPlayerButton = new JButton(addPlayer1String);
    JLabel currentHostLabel = new JLabel("Current Host: ");
    JButton openHostPhrasePaneButton = new JButton("Open Host Phrase Pane");
    public static JLabel playingPhraseLabel = new JLabel("Playing Phrase: ");
    JButton startGameButton = new JButton("Start Game");

    public GUI () {

        super("Wheel of Wonder");

        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        //Requirement 4a - Add a Menu Bar
        JMenuBar menuBar = new JMenuBar();

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