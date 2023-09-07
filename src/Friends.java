
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jenna Rigby
 * Class contains the reading to and from the Friends Array
 */
public class Friends {
    private Friend[] allFriends;
    private int size;
    private DBConnection db;
    private ResultSet rs;

    /**
     *
     * @param db
     * @throws SQLException
     */
    public Friends(DBConnection db) throws SQLException {
        this.db = db;
        size = getArraySize();
        populateFriendArray();
    }
    
    /**
     * Closes the database
     */
    public void close(){
        db.close();
    }

    /**
     *
     * @return Friend array
     */
    public Friend[] getAllFriends() {
        return allFriends;
    }
    
    /**
     *
     * @param i
     * @return Friend
     */
    public Friend getFriend(int i) {
        return allFriends[i];
    }

    /**
     *
     * @param allFriends
     */
    public void setAllFriends(Friend[] allFriends) {
        this.allFriends = allFriends;
    }

    /**
     *
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     *
     * @return int
     * @throws SQLException
     * Gets the size of the Friend array from the Friends table in the database
     */
    public int getArraySize() throws SQLException {
            String sql = "SELECT COUNT(*) AS Size FROM Friends";
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
     * Reads all data from the friends table in the database into the 
     * Friends array
     */
    public void populateFriendArray() throws SQLException {
        allFriends= new Friend[size];  
        String sql = "SELECT * FROM Friends";   
        rs = db.runSelect(sql);
        for (int i = 0; i < size; i++) {
           rs.next();
           String username = rs.getString("Username");  
           String friend = rs.getString("FriendUsername");
           
           allFriends[i] = new Friend(username, friend);
        }
        rs.close();      
    }
     
    /**
     *
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet returnRS() throws SQLException{
         allFriends = new Friend[size];
        String sql = "SELECT * FROM Users";
        
        rs = db.runSelect(sql);
        return rs;
    }
    
    
    
}
