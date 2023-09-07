
/**
 *
 * @author Jenna Rigby
 * This class is used to set each variable that forms part of a song object.
 */
public class Song {
    private int songID;
    private String songName;
    private String username;
    private double length;
    private String song;

    /**
     *
     * @param songID
     * @param songName
     * @param username
     * @param length
     * @param song
     */
    public Song(int songID, String songName, String username, double length,
             String song) {
        this.songID = songID;
        this.songName = songName;
        this.username = username;
        this.length = length;
        this.song = song;
    }

    /**
     *
     * @return int
     */
    public int getSongID() {
        return songID;
    }

    /**
     *
     * @param songID
     */
    public void setSongID(int songID) {
        this.songID = songID;
    }

    /**
     *
     * @return String
     */
    public String getSongName() {
        return songName;
    }

    /**
     *
     * @param songName
     */
    public void setSongName(String songName) {
        this.songName = songName;
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

    /**
     *
     * @return double
     */
    public double getLength() {
        return length;
    }

    /**
     *
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     *
     * @return String
     */
    public String getSong() {
        return song;
    }

    /**
     *
     * @param song
     */
    public void setSong(String song) {
        this.song = song;
    }
  
    
}
