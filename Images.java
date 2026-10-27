import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Images {

    static File[] files = {
        null,
        null,
        null,
        null,
        null,
        null,
        null
    };

    static BufferedImage[] bufferedImages = {
        null,
        null,
        null,
        null,
        null,
        null,
        null
    };

    static String[] imageURLs = {
        //new car
        "https://cdn.pixabay.com/photo/2020/05/19/10/05/opel-5190050_1280.jpg",

        //Hawaii vacation
        "https://media.istockphoto.com/id/117211856/photo/where-coconuts-grow.jpg?s=2048x2048&w=is&k=20&c=sWuRir8ewbtcnAcmbr_UcWPX3c1OZb9DNz59h-ERbGA=",

        //flat screen TV
        "https://media.istockphoto.com/id/1395191574/photo/black-led-tv-television-screen-blank-isolated.jpg?s=2048x2048&w=is&k=20&c=LFjt1mNK4N7Ak2Z69aHjB9rjct1DDrIR3P9nhK5dcsY=",

        //lifetime supply of ice cream
        "https://media.istockphoto.com/id/2153490093/photo/three-glasses-of-ice-cream-with-balls-decorated-on-table.jpg?s=2048x2048&w=is&k=20&c=ys8fOgrSBIhuygZJfiLF4q4PbMbcjpZ2q7fF2b1MGEA=",

        //one-year movie theater membership
        "https://cdn.pixabay.com/photo/2024/06/23/20/54/ai-generated-8848753_1280.jpg",

        //fruit basket
        "https://cdn.pixabay.com/photo/2018/05/14/12/31/fruit-3399834_1280.jpg",

        //golden ticket
        "https://plus.unsplash.com/premium_photo-1729000859432-ea513184898b?q=80&w=880&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=NHwxMjA3fDA%3D"
    };


    public void readFromFile(int i) {
        try {
            files[i] = new File(imageURLs[i]);
            bufferedImages[i] = new BufferedImage(500,300, BufferedImage.TYPE_INT_RGB);
            bufferedImages[i] = ImageIO.read(files[i]);
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + ", please try again.");
        }
    }


}