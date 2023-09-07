
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jenna Rigby
 */
public class Voters {
    private Voter[] allVoters;
    private int size = 0;
    private DBConnection db;
    private ResultSet rs;

    /**
     *
     * @param db
     * @throws SQLException
     */
    public Voters(DBConnection db) throws SQLException {
        this.db = db;
        populateVoterArray();
        size = getArraySize();
    }
    
    /**
     * Closes the database
     */
    public void close() {
        db.close();
    }
    
    /**
     *
     * @return int
     * @throws SQLException
     * Determines the size of the array from the 'Voters' table
     */
    public int getArraySize() throws SQLException {
            String sql = "SELECT COUNT(*) AS Size FROM Voters";
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
     * Reads all information from 'Voters' table into Voters array using a query
     */
    public void populateVoterArray() throws SQLException{
        allVoters = new Voter[size];
        String sql = "SELECT * FROM Voters";
        
        rs = db.runSelect(sql);
        for (int i = 0; i < size; i++) {
            rs.next(); 
            int compID = rs.getInt("CompetitionID");
            String voterUsername = rs.getString("VoterUsername");
            int selection = rs.getInt("Selection");
           
            allVoters[i] = new Voter(compID, voterUsername, selection);
        }
        rs.close();   
    }
     
    /**
     *
     * @param i
     * @return Voter
     */
    public Voter getVoter(int i) {
        return allVoters[i];
    }
     
    /**
     *
     * @param username
     * @return
     * Reads all competitions where the winner has 'to be determined ' that 
     * the user has not yet voted for, from the 'Competitions' table and 
     * determines the index, so the competition can be displayed and voted on. 
     */
    public String displayCompetitions(String username){
        int compIndex = 0;
        try {
            
            Competitions comps = new Competitions(db);
            comps.populateCompArray();
            Voters voters = new Voters(db);
            voters.populateVoterArray();
            String status = "";
            for (int i = 0; i < comps.getArraySize(); i++) {
                
                if (comps.getCompetition(i).getWinner().equals("tbd") && 
                        compIndex != i) {
                    
                    for (int j = 0; j < voters.getArraySize(); j++) {
                        
                        if ((voters.getVoter(j).getVoterUsername().
                                equalsIgnoreCase(username)) && comps.
                                getCompetition(i).getCompetitionID()
                                == voters.getVoter(j).getCompID()) {
                            
                            status = "false";
                            break;
                        } else {
                            
                            status = "true";
                            compIndex = i;
                            
                        }//end else
                    }//end inner for  
                    if (status.equals("true")) {
                        break;
                    }
                }
                else{
                    status = "false";
                    
                }   
                }//end outer for
                
                return compIndex + " " + status;  
                
        } catch (SQLException ex) {
            System.out.println("Error connecting to database.");
        }

      return "";
    }
}
