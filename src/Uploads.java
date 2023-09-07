
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Jenna Rigby
 * Class creates Uploads array and allows it to be called when necessary.
 */
public class Uploads {
    private Upload[] allUploads;
    private int size = 0;
    private DBConnection db;
    private ResultSet rs;

    /**
     *
     * @param db
     * @throws SQLException
     */
    public Uploads(DBConnection db) throws SQLException {
        this.db = db;
        size = getArraySize();
        populateUploadsArray();
    }
    
    /**
     * Closes the database.
     */
    public void close() {
        db.close();
    }
    
    /**
     *
     * @return
     * @throws SQLException
     * Determines the sizes of the array by using a query to count all entries
     * in the uploads table in the database
     */
    public int getArraySize() throws SQLException {
            String sql = "SELECT COUNT(*) AS Size FROM Uploads";
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
     * Reading all records from Uploads table in the database into the Uploads
     * array.
     */
    public void populateUploadsArray() throws SQLException{
        allUploads = new Upload[size];
        String sql = "SELECT * FROM Uploads";
        
        rs = db.runSelect(sql);
        for (int i = 0; i < size; i++) {
            rs.next(); 
            int soundID = rs.getInt("SoundID");
            String soundName = rs.getString("SoundName");
            String username = rs.getString("Username");
            allUploads[i] = new Upload(soundID, soundName, username);
        }
        rs.close();   
    }
    
    /**
     *
     * @param i
     * @return Upload
     */
    public Upload getUpload(int i) {
        return allUploads[i];
    }
}
