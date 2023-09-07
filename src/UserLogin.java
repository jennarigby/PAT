
import java.sql.SQLException;

/**
 *
 * @author Jenna Rigby
 * Class is used to complete processing for the Login Screen.
 */
public class UserLogin {
    private String usernameLogin;
    private String passwordLogin;
    private String usernameSignUp;
    private String emailSignUp;
    private String passwordSignUp;
    private boolean userValid;
    private DBConnection db;

    /**
     *
     * @param db
     */
    public UserLogin(DBConnection db) {
        this.db = db;
    }

    /**
     *
     * @param usernameLogin
     * @param passwordLogin
     * @param usernameSignUp
     * @param emailSignUp
     * @param passwordSignIn
     */
    public UserLogin(String usernameLogin, String passwordLogin, String
            usernameSignUp, String emailSignUp, String passwordSignIn) {
        this.usernameLogin = usernameLogin;
        this.passwordLogin = passwordLogin;
        this.usernameSignUp = usernameSignUp;
        this.emailSignUp = emailSignUp;
        this.passwordSignUp = passwordSignIn;
    }

    /**
     *
     * @return String
     */
    public String getUsernameLogin() {
        return usernameLogin;
    }

    /**
     *
     * @param usernameLogin
     */
    public void setUsernameLogin(String usernameLogin) {
        this.usernameLogin = usernameLogin;
    }

    /**
     *
     * @return String
     */
    public String getPasswordLogin() {
        return passwordLogin;
    }

    /**
     *
     * @param passwordLogin
     */
    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    /**
     *
     * @return String
     */
    public String getUsernameSignUp() {
        return usernameSignUp;
    }

    /**
     *
     * @param usernameSignUp
     */
    public void setUsernameSignUp(String usernameSignUp) {
        this.usernameSignUp = usernameSignUp;
    }

    /**
     *
     * @return String
     */
    public String getEmailSignUp() {
        return emailSignUp;
    }

    /**
     *
     * @param emailSignUp
     */
    public void setEmailSignUp(String emailSignUp) {
        this.emailSignUp = emailSignUp;
    }

    /**
     *
     * @return String
     */
    public String getPasswordSignUp() {
        return passwordSignUp;
    }

    /**
     *
     * @param passwordSignUp
     */
    public void setPasswordSignUp(String passwordSignUp) {
        this.passwordSignUp = passwordSignUp;
    }

    /**
     *
     * @return boolean
     */
    public boolean isUserValid() {
        return userValid;
    }

    /**
     *
     * @param userValid
     */
    public void setUserValid(boolean userValid) {
        this.userValid = userValid;
    }
    
    /**
     *
     * @throws SQLException
     * Checks if the username and password entered match a username and password
     * in the 'Users' table. A loop is used to run through the entire array of
     * users.
     */
    public void checkLogin() throws SQLException{
        DBConnection db = new DBConnection();
        Users allUsers = new Users(db);
        allUsers.populateUserArray();
        for (int i = 0; i < allUsers.getArraySize(); i++) {
            if (getUsernameLogin().equalsIgnoreCase(allUsers.getUser(i).
            getUsername())
                    && passwordLogin.equals
        (allUsers.getUser(i).getPassword())) {
                userValid = true;
               
                break;
            }
            else {
                userValid = false;
            }
        }      
    }
    
    /**
     *
     * @throws SQLException
     * Inserts a new user into the 'Users' table if the username doesn't 
     * already exist. A loop is used to run through the entire array of users.
     */
    public void insertNewUser() throws SQLException{
        DBConnection db = new DBConnection();
        Users allUsers = new Users(db);
        allUsers.populateUserArray();
        
        for (int i = 0; i < allUsers.getArraySize(); i++) {
            if (getUsernameSignUp().equalsIgnoreCase(allUsers.getUser(i).
                 getUsername())) {
                userValid = false;
                break;
            } 
            else{
                userValid = true;
            }
        }
        
       if (isUserValid()) {
            db.addUser(usernameSignUp, emailSignUp, passwordSignUp, 0);
        }
       }    
    
    }
    
    
