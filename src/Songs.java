
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jenna Rigby
 * Class contains reading from the Song table in the database into the songs 
 * array and allows this array to be called when necessary. 
 */
public class Songs {

    private Song[] allSongs;
    private int size = 0;
    private DBConnection db;
    private ResultSet rs;

    /**
     *
     * @param db
     * @throws SQLException
     */
    public Songs(DBConnection db) throws SQLException {
        this.db = db;
        size = getArraySize();
        populateSongArray();
    }

    /**
     * Closes the database
     */
    public void close() {
        db.close();
    }
    
    /**
     *
     * @return int
     * @throws SQLException
     * Determines the size of the song array using a query in the database.
     */
    public int getArraySize() throws SQLException {
            String sql = "SELECT COUNT(*) AS Size FROM Songs";
            rs = db.runSelect(sql);
            while (rs.next()) {
                size = rs.getInt("Size");
                return rs.getInt("Size");

        }
        return 0;
    }
      
    /**
     *
     * @throws SQLException
     * Reads all data from the Songs table into the Songs array
     */
    public void populateSongArray() throws SQLException{
        allSongs = new Song[size];
        String sql = "SELECT * FROM Songs";
        
        rs = db.runSelect(sql);
        for (int i = 0; i < size; i++) {
            rs.next(); 
            int songID = rs.getInt("SongID");
            String songName = rs.getString("SongName");
            String username = rs.getString("Username");
            double length = rs.getDouble("Length");
            String song = rs.getString("Song");
           
            allSongs[i] = new Song(songID, songName, username, length, song);
        }
        rs.close();   
    }

    /**
     *
     * @param i
     * @return Song
     */
    public Song getSong(int i) {
        return allSongs[i];
    }
}
