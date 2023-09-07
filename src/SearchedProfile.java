
/**
 *
 * @author Jenna Rigby
 * This class displays retrieves all the details of the searched username from
 * the database so it can be displayed on the SearchedProfileScreen
 */
public class SearchedProfile {
    private String username; //Searched username
    private String level;
    private int score;
    private int rank;
    private User[] allUsers;

    /**
     *
     * @param username
     */
    public SearchedProfile(String username){
        this.username = username;
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
    public String getLevel() {
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
     * @return int
     */
    public int getScore() { 
        return score;
    }

    /**
     *
     * @param score
     * Determines the score of the searched user by searching the database using
     * the username.
     */
    public void setScore(int score) {
        for (int i = 0; i < allUsers.length; i++) {
          if (allUsers[i].getUsername().equalsIgnoreCase(username)) {
           this.score = allUsers[i].getScore();
          }  
        }
        this.score = score;
    }

    /**
     *
     * @return int
     */
    public int getRank() {     
        return rank;
    }

    /**
     *
     * @param rank
     */
    public void setRank(int rank) {
        for (int i = 0; i < allUsers.length; i++) {
           this.rank = i; 
        }     
    }
    
   
}
