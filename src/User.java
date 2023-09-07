
/**
 *
 * @author Jenna Rigby
 */

public class User {
    private String username;
    private String email;
    private String password;
    private int score;

    /**
     *
     * @param username
     * @param email
     * @param password
     * @param score
     */
    public User(String username, String email, String password, int score) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.score = score;
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
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

}
