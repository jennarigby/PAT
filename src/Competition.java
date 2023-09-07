
/**
 *
 * @author Jenna Rigby
 * Class contains all variables that form part of Competitions array
 */
public class Competition {
    private int competitionID; 
    private String user1;
    private String user2;
    private String song1;
    private String song2;
    private int VotesForOne;
    private int VotesForTwo;
    private String winner;

    /**
     *
     * @param competitionID
     * @param user1
     * @param user2
     * @param song1
     * @param song2
     * @param VotesForOne
     * @param VotesForTwo
     * @param winner
     */
    public Competition(int competitionID, String user1, String user2, String 
            song1, String song2, int VotesForOne, int VotesForTwo, 
            String winner) {
        this.competitionID = competitionID;
        this.user1 = user1;
        this.user2 = user2;
        this.song1 = song1;
        this.song2 = song2;
        this.VotesForOne = VotesForOne;
        this.VotesForTwo = VotesForTwo;
        this.winner = winner;
    }  

    /**
     *
     * @return int
     */
    public int getCompetitionID() {
        return competitionID;
    }

    /**
     *
     * @param competitionID
     */
    public void setCompetitionID(int competitionID) {
        this.competitionID = competitionID;
    }

    /**
     *
     * @return string
     */
    public String getUser1() {
        return user1;
    }

    /**
     *
     * @param user1
     */
    public void setUser1(String user1) {
        this.user1 = user1;
    }

    /**
     *
     * @return String
     */
    public String getUser2() {
        return user2;
    }

    /**
     *
     * @param user2
     */
    public void setUser2(String user2) {
        this.user2 = user2;
    }

    /**
     *
     * @return String
     */
    public String getSong1() {
        return song1;
    }

    /**
     *
     * @param song1
     */
    public void setSong1(String song1) {
        this.song1 = song1;
    }

    /**
     *
     * @return String
     */
    public String getSong2() {
        return song2;
    }

    /**
     *
     * @param song2
     */
    public void setSong2(String song2) {
        this.song2 = song2;
    }

    /**
     *
     * @return int
     */
    public int getVotesForOne() {
        return VotesForOne;
    }

    /**
     *
     * @param VotesForOne
     */
    public void setVotesForOne(int VotesForOne) {
        this.VotesForOne = VotesForOne;
    }

    /**
     *
     * @return int
     */
    public int getVotesForTwo() {
        return VotesForTwo;
    }

    /**
     *
     * @param VotesForTwo
     */
    public void setVotesForTwo(int VotesForTwo) {
        this.VotesForTwo = VotesForTwo;
    }

    /**
     *
     * @return String
     */
    public String getWinner() {
        return winner;
    }

    /**
     *
     * @param winner
     */
    public void setWinner(String winner) {
        this.winner = winner;
    }
    
    
}
