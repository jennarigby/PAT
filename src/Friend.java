
/**
 *
 * @author Jenna Rigby
 * Class contains every variable in Friends array
 */
public class Friend {
    private String username;
    private String friend;

    /**
     *
     * @param username
     * @param friend
     */
    public Friend(String username, String friend) {
        this.username = username;
        this.friend = friend;
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
    public String getFriend() {
        return friend;
    }

    /**
     *
     * @param friend
     */
    public void setFriend(String friend) {
        this.friend = friend;
    }
    
    
    
    
    
}
