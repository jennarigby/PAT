
import java.sql.SQLException;


/**
 *
 * @author Jenna Rigby
 * Class is used to do all processing for SettingsScreen
 */
public class Settings {
    private String username;
    private String email;
    private String password;

    /**
     *
     * @param username
     * @param email
     * @param password
     */
    public Settings(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     *
     * @param newUser
     * @return boolean
     * @throws SQLException
     * If a user changes their email or password, it will update in the 'Users'
     * table on the database.
     */
    public boolean updateUserInfo(String newUser) throws SQLException{
        String newUsername = newUser;
        DBConnection db = new DBConnection();
        Users allUsers = new Users(db);
        allUsers.populateUserArray();
        for (int i = 0; i < allUsers.getArraySize(); i++){
            if (!newUsername.equalsIgnoreCase(allUsers.getUser(i).getUsername())
                   || newUsername.equalsIgnoreCase(username)) {
                return true;
            }
            else{
               return false; 
            }
        }
        return false;
    }
    
  
    
}
