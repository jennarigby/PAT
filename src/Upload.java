
/**
 *
 * @author Jenna Rigby
 * Class allows all fields in the Uploads array to be called.
 */
public class Upload {
    private int soundID;
    private String soundName;
    private String username;

    /**
     *
     * @param soundID
     * @param soundName
     * @param username
     */
    public Upload(int soundID, String soundName, String username) {
        this.soundID = soundID;
        this.soundName = soundName;
        this.username = username;
    }

    /**
     *
     * @return int
     */
    public int getSoundID() {
        return soundID;
    }

    /**
     *
     * @param soundID
     */
    public void setSoundID(int soundID) {
        this.soundID = soundID;
    }

    /**
     *
     * @return String 
     */
    public String getSoundName() {
        return soundName;
    }

    /**
     *
     * @param soundName
     */
    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    /**
     *
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

  
    
    
    
}
