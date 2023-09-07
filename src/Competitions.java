
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Jenna Rigby
 * Class populates an array of competition objects from the 'Competitions' table in 
 * the database
 */
public class Competitions {
    private Competition[] allCompetitions;
    private int size;
    private DBConnection db;
    private ResultSet rs;

    /**
     *
     * @param db
     * @throws SQLException
     */
    public Competitions(DBConnection db) throws SQLException {
        this.db = db;
        size = getArraySize();
        populateCompArray();
    }
    
    /**
     * Closes the database
     */
    public void close(){
        db.close();
    }
    
    /**
     *
     * @return int
     * @throws SQLException
     * Determines the size of the Competitions array from the database
     */
    public int getArraySize() throws SQLException {
            String sql = "SELECT COUNT(*) AS Size FROM Competitions";
            rs = db.runSelect(sql);
            while (rs.next()) {
                size = rs.getInt("Size");
                return rs.getInt("Size");

        }
        return 0;
    }
    
    /**
     *
     * @param i (int)
     * @return Competition
     */
    public Competition getCompetition(int i) {
        return allCompetitions[i];
    }
      
    /**
     *
     * @throws SQLException
     * Reads all competitions from the database into the array
     */
    public void populateCompArray()throws SQLException{
        allCompetitions = new Competition[size];
        String sql = "SELECT * FROM Competitions";
        
        rs = db.runSelect(sql);
        
        for (int i = 0; i < size; i++) {
            rs.next(); 
            int compID  = rs.getInt("CompetitionID");  
            String user1 = rs.getString("User1");
            String user2 =  rs.getString("User2");
            String song1 = rs.getString("Song1");
            String song2 = rs.getString("Song2"); 
            int votesFor1 = rs.getInt("VotesFor1");
            int votesFor2 = rs.getInt("VotesFor2");
            String winner = rs.getString("Winner");
            
            allCompetitions[i] = new Competition(compID, user1, user2, song1, 
                    song2, votesFor1, votesFor2, winner);
        
        }
        rs.close();
      }
    
    /**
     *
     * @return ResultSet
     * @throws SQLException
     * Returns all data from Competitions table in database.
     */
    public ResultSet returnRS() throws SQLException{
         allCompetitions = new Competition[size];
        String sql = "SELECT * FROM Users";
        
        rs = db.runSelect(sql);
        return rs;
    }
    
    /**
     * Determines the winner of competitions where the winner is 'to be 
     * determined ' and the one of the competitors votes are greater than 30.
     * The winner's score is increased by 10.
     */
    public void assignWinner(){
        try {
            DBConnection db = new DBConnection();
            Competitions comps = new Competitions(db);
            comps.populateCompArray();
            Users users = new Users(db);
            boolean checkWinner = false;
            int i = 0;
            while ( i < comps.getArraySize() && checkWinner == false) {

                if (comps.getCompetition(i).getWinner().equals("tbd")
                        && (comps.getCompetition(i).getVotesForOne() >= 30
                        || comps.getCompetition(i).getVotesForTwo() >= 30)) {
                    
                    int compID = comps.getCompetition(i).getCompetitionID();
                    if (comps.getCompetition(i).getVotesForTwo() > comps
                            .getCompetition(i).getVotesForOne()) {
                        db.addWinner(compID, comps.getCompetition(i).
                                getUser2());
                        db.updateScore(compID, comps.getCompetition(i).
                                getUser2(), users.getUser(i).
                                        getScore() + 10);
                        checkWinner = true;
                        
                        
                    } else {
                        db.addWinner(compID, comps.getCompetition(i).
                                getUser1());
                        db.updateScore(compID, comps.getCompetition(i).
                                getUser1(), users.getUser(i).getScore() + 10);
                        checkWinner = true;
                       
                    }
                    
                } 
                i++;
            }
        } catch (SQLException ex) {
            System.out.println("Error connecting to the database.");
        }
       
    }
}

