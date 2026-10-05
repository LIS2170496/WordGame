import java.awt.*;
import javax.swing.*;


public class GUI extends JFrame {

    int frameWidth = 500;
    int frameHeight = 500;

    public GUI () {

        super("Wheel of Wonder");

        setSize(frameWidth, frameHeight);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

    }

    
    
}
