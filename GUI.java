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
    JMenuItem layoutMenuItem;

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


        //Requirement 4e - Add About menu
        JMenu aboutMenu = new JMenu("About");
        //Requirement 4e - Enable use Alt-A to access
        aboutMenu.setMnemonic('A');

        //Requirement 4f - Add a menu item to the About menu called Layout. 
        layoutMenuItem = new JMenuItem("Layout");
        aboutMenu.add(layoutMenuItem);
        menuBar.add(aboutMenu);





        setVisible(true);
        
        

        addHostMenuItem.setEnabled(false);
        addHostMenuItem.setVisible(false);





        //Panels
        //Requirement 4d - Use JPanels

        JPanel currentPlayersLabelContainer = new JPanel();
        //currentPlayersLabelContainer.setBackground(Color.pink);
        currentPlayersLabelContainer.setBounds(0,10,500,50);
        currentPlayersLabelContainer.add(currentPlayersLabel);
        add(currentPlayersLabelContainer);

        JPanel currentHostLabelContainer = new JPanel();
        //currentHostLabelContainer.setBackground(Color.lightGray);
        currentHostLabelContainer.setBounds(0,65,500,50);
        currentHostLabelContainer.add(currentHostLabel);
        add(currentHostLabelContainer);

        JPanel playingPhraseLabelContainer = new JPanel();
        //playingPhraseLabelContainer.setBackground(Color.pink);
        playingPhraseLabelContainer.setBounds(0,120,500,50);
        playingPhraseLabelContainer.add(playingPhraseLabel);
        add(playingPhraseLabelContainer);

        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setBounds(0,175,500,50);
        buttonsContainer.add(startGameButton);
        add(buttonsContainer);


        startGameButton.setEnabled(false);
        startGameButton.setVisible(false);







    }
}