import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.net.URI;
import java.net.URL;

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
        "https://media.istockphoto.com/id/117211856/photo/where-coconuts-grow.jpg",

        //flat screen TV
        "https://media.istockphoto.com/id/1395191574/photo/black-led-tv-television-screen-blank-isolated.jpg",

        //lifetime supply of ice cream
        "https://media.istockphoto.com/id/2153490093/photo/three-glasses-of-ice-cream-with-balls-decorated-on-table.jpg",

        //one-year movie theater membership
        "https://cdn.pixabay.com/photo/2024/06/23/20/54/ai-generated-8848753_1280.jpg",

        //fruit basket
        "https://cdn.pixabay.com/photo/2018/05/14/12/31/fruit-3399834_1280.jpg",

        //golden ticket
        "https://cdn.pixabay.com/photo/2017/08/06/04/06/gold-2588578_1280.jpg"
    };


    public Images() {
        int i = 0;
        try {
            for (i = 0; i < imageURLs.length; ++i) {
                URL url = URI.create(imageURLs[i]).toURL();
                bufferedImages[i] = ImageIO.read(url);
            }
        }
        catch(IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " for file # " + i + ", please try again.");
        }
    }




}