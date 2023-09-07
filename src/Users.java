import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jenna
 */
public class Users {
    private User[] allUsers;
    private int size = 0;
    private DBConnection db;
    private ResultSet rs;
    
    /**
     *
     * @param db
     * @throws SQLException
     */
    public Users(DBConnection db) throws SQLException {
        this.db = db;
        size = getArraySize();
        populateUserArray();
    }
    
    /**
     * Closes the database.
     */
    public void close(){
    db.close();
    }

    /**
     *
     * @return User array
     */
    public User[] getAllUsers() {
        return allUsers;
    }

    /**
     *
     * @param allUsers
     */
    public void setAllUsers(User[] allUsers) {
        this.allUsers = allUsers;
    }

    /**
     *
     * @param i
     * @return
     */
    public User getUser(int i) {
        return allUsers[i];
    }
    
    /**
     *
     * @return
     * @throws SQLException
     * Determines the size of the Users array from the 'Users' table
     */
    public int getArraySize() throws SQLException {
            String sql = "SELECT COUNT(*) AS Size FROM Users";
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
     * Reads all User information into the Users array from the 'Users' table 
     * using a query.
     */
    public void populateUserArray() throws SQLException {
        allUsers = new User[size];
        String sql = "SELECT * FROM Users";
        
        rs = db.runSelect(sql);
        
        for (int i = 0; i < size; i++) {
            rs.next(); 
            String username = rs.getString("Username");  
            String email = rs.getString("Email");
            String password = rs.getString("Password");
            int score = rs.getInt("Score");
           
            allUsers[i] = new User(username, email, password, score);
        }
        rs.close();

    }
       
    /**
     *
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet returnRS() throws SQLException{
         allUsers = new User[size];
        String sql = "SELECT * FROM Users";
        
        rs = db.runSelect(sql);
        return rs;
    }
    
    /**
     * Sorts the users in the User Array from highest to lowest score using 
     * loops.
     */
    public void sortUsers(){
        User temp;
        for (int i = 0; i < size -1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (allUsers[i].getScore() < allUsers[j].getScore()) {
                     temp = allUsers[i];
                     allUsers[i] = allUsers[j];
                     allUsers[j] = temp;
                }
            }
        }
    }
    
    
}


    
