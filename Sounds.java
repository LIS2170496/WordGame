import java.net.URL;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class Sounds {
    
    static String[] soundURLs = {
        //correct
        //https://freesound.org/s/791980/
        //  soundURL[0]
        "/correct.wav",

        //sound name
        //sound attribution
        ""
    };

    Clip clip;
    URL soundURL[] = new URL[3];



    public Sounds() {
        soundURL[0] = getClass().getResource(soundURLs[0]);
    }




    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " for audio file # " + i + ", please try again.");
        }

    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }

}
