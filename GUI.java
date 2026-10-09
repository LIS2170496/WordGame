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

    JMenuItem addPlayerMenuItem;
    JMenuItem addHostMenuItem;

    public GUI () {

        super("Wheel of Wonder");

        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //FIXME - review later
        setLayout(null);

        //Requirement 4a - Add a Menu Bar
        JMenuBar menuBar = new JMenuBar();

        //Requirement 4b - Create a Menu called Game
        JMenu gameMenu = new JMenu("Game");

        //Requirement 4c - Add Player and Add Host buttons are menu items under the Game menu 
        addPlayerMenuItem = new JMenuItem("Add Player1");
        addHostMenuItem = new JMenuItem("Add Host");

        gameMenu.add(addPlayerMenuItem);
        gameMenu.add(addHostMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        //Requirement 4b - Enable Alt-G to access the Game menu
        gameMenu.setMnemonic('G');
        




        //add(addNewPlayerButton);
        
        //add(openHostPhrasePaneButton);
        add(currentHostLabel);
        add(playingPhraseLabel);
        add(startGameButton);
        setVisible(true);

        //openHostPhrasePaneButton.setEnabled(false);
        //openHostPhrasePaneButton.setVisible(false);

        startGameButton.setEnabled(false);
        startGameButton.setVisible(false);

        addHostMenuItem.setEnabled(false);
        addHostMenuItem.setVisible(false);





        //Panels
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.pink);
        topPanel.setBounds(0,0,500,50);
        topPanel.add(currentPlayersLabel);
        add(topPanel);






    }
}