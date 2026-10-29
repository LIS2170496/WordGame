import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class WinAnimationPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 580;
    final int PANEL_HEIGHT = 150;
    Image winImage;

    Timer timer;

    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    WinAnimationPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        winImage = new ImageIcon(Images.bufferedImages[7]).getImage();
        timer = new Timer(10, this);
        timer.start();
    }


    public void paint(Graphics g) {
        //FIXME - this was used to paint the background, may not be necessary
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(winImage, x, y, null);
    }


    @Override 
    public void actionPerformed(ActionEvent e) {
        x = x + xVelocity;
        repaint();
    }





}
