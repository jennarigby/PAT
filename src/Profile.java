
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jenna Rigby
 * Backend class for UserProfileScreen
 */
public class Profile {
    private String username; //the user's username
    private String level;
    private int score;
    private int rank;
    private String[] friends;
    private ResultSet rs;
    private DBConnection db;

    /**
     *
     * @param username
     */
    public Profile(String username) {

       this.username = username;              
    }

    public Profile() {
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
     * @return String
     * @throws SQLException
     * Obtains the users level by calculation using their score
     */
    public String getLevel() throws SQLException {
        level = "" + (getScore()/100 + 1);
        return level;
    }

    /**
     *
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     *
     * @return
     * @throws SQLException
     * Determines the users score from the database using their username.
     */
    public int getScore() throws SQLException {
          DBConnection db = new DBConnection();
        Users allUsers = new Users(db);
        for (int i = 0; i < allUsers.getArraySize(); i++) {
            if (username.equalsIgnoreCase(allUsers.getUser(i).getUsername())) {
                score = allUsers.getUser(i).getScore();
            }
        }     
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {     
        this.score = score;
    }

    /**
     *
     * @return int
     * @throws SQLException
     * Determines the users rank bases on their score after the users have been
     * sorted from highest to lowest score.
     */
    public int getRank() throws SQLException {  
        rank = 0;
        DBConnection db = new DBConnection();
        Users allUsers = new Users(db);
        allUsers.sortUsers();
         for (int i = 0; i < allUsers.getArraySize(); i++) {
             rank++;
            if (username.equalsIgnoreCase(allUsers.getUser(i).getUsername())) {
                break;      
            }
        } 
        return rank;
    }

    /**
     *
     * @param rank
     */
    public void setRank(int rank){
        this.rank = rank;
    }
    
    
    /**
     *
     * @return
     * @throws SQLException 
     * Gets the users friends from the Friends table in the database using their
     * username to search. This is added to the Friends array to be displayed.
     */
    public String[] getFriends() throws SQLException{
        int friendSize = 0;
        
        
        friends = new String[50];
        String sql = "SELECT * FROM Friends WHERE Username = '" + username
                + "'";
         rs = db.runSelect(sql);
         
         for (int i = 0; i < 50; i++) {
            rs.next(); 
            friends[i] = rs.getString("FriendUsername");
        }
        rs.close();
        
        return null;
    }
 

}
