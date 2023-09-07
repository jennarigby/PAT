import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Jenna Rigby
 * Class allows audio to be played from the PlayScreen and CreateScreen UIs
 */

public class Create {
private Clip clip;

    public Create()  {    
       
    }
    
    /**
     *
     * @param soundName
     * @return boolean 
     * Creates an audioInputStream and opens it as a sound clip, enabling the
     * audio to play from any WAV file of the selected name. 
     */
    public boolean playAudio(String soundName) {
        boolean played = false;
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
          (new File(soundName).getAbsoluteFile());
             clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            played = true;
            return played;
        } catch (Exception ex) {
            System.out.println("Error when trying to play file.");
        }
        return played;
    }
    
    //Stops the audio clip
    public void endAudio(){      
            clip.stop();
    }


}
