
/**
 *
 * @author Jenna Rigby
 */
public class Voter {
    private int compID;
    private String voterUsername;
    private int selection;

    /**
     *
     * @param compID
     * @param voterUsername
     * @param selection
     */
    public Voter(int compID, String voterUsername, int selection) {
        this.compID = compID;
        this.voterUsername = voterUsername;
        this.selection = selection;
    }

    /**
     *
     * @return int
     */
    public int getCompID() {
        return compID;
    }

    /**
     *
     * @param compID
     */
    public void setCompID(int compID) {
        this.compID = compID;
    }

    /**
     *
     * @return String
     */
    public String getVoterUsername() {
        return voterUsername;
    }

    /**
     *
     * @param voterUsername (String)
     */
    public void setVoterUsername(String voterUsername) {
        this.voterUsername = voterUsername;
    }

    /**
     *
     * @return int
     */
    public int getSelection() {
        return selection;
    }

    /**
     *
     * @param selection (int)
     */
    public void setSelection(int selection) {
        this.selection = selection;
    }
    
    
    
}
