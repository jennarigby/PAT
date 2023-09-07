
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jenna Rigby
 * Class connects program to database to allow the adding, deleting, and 
 * updating of the user's data.
 */
public class DBConnection {

    private String con = "jdbc:ucanaccess://MusicMix.accdb";
    private static Connection connection;
    private Statement stmt;
    private ResultSet resultSet;

    /**
     * Connects program to database
     */
    public DBConnection() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            connection = DriverManager.getConnection(con);
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error while establishing "
                    + "connection to database");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
    }

    /**
     *
     * @param username
     * @param email
     * @param password
     * @param score
     * Adds a user to the 'Users' table in the database when a user signs up
     */
    public void addUser(String username, String email, String password,
            int score) {
        try {

            PreparedStatement pStatement = connection.prepareStatement(
                    "INSERT INTO Users(Username,Email,Password,Score) "
                    + "values(?,?,?,?)");
            pStatement.setString(1, username);
            pStatement.setString(2, email);
            pStatement.setString(3, password);
            pStatement.setInt(4, score);

            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while adding "
                    + "user to database");
        }
    }

    /**
     *
     * @param username
     * @param email
     * @param password
     * @param score
     * Updates user's login information in the 'Users' table
     */
    public void updateUser(String username, String email, String password,
            int score) {

        try {
           String sql = "UPDATE Users SET Email = '" + email + "', Password = "
                    + "'" + password + "' WHERE Username = '" + username + "'";

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    

    /**
     *
     * @param songName
     * @param username
     * @param length
     * @param song
     * Inserts the user's creations/songs into the 'Songs' table 
     */
    public void addSong(String songName, String username, int length,
            String song) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("INSERT "
                    + "INTO Songs(SongID, SongName, Username, Length, "
                    + "Song) VALUES (?,?,?,?,?)");
            pStatement.setInt(1, 10);
            pStatement.setString(2, songName);
            pStatement.setString(3, username);
            pStatement.setInt(4, length);
            pStatement.setString(5, song);

            pStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error while adding song to database");
        }
    }

    /**
     *
     * @param user1
     * @param user2
     * @param song1
     * @param song2
     * @param votesFor1
     * @param VotesFor2
     * @param winner
     * Inserts a competition into the 'Competitions' table every time a user 
     * submits a creation in play mode.
     */
    public void addCompetition(String user1, String user2,
            String song1, String song2, int votesFor1, int VotesFor2, String
                    winner) {

        try {
            String sql = "INSERT INTO"
                    + " Competitions(CompetitionID, User1, User2, Song1, "
                    + "Song2, VotesFor1, VotesFor2, Winner) VALUES (" + 1 + ",'"
                    + user1 + "','" + user2 + "','" + song1 + "','" + song2 + 
                    "',"
                    + votesFor1 + "," + VotesFor2 + ",'" + winner + "')";

            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Error while adding Competition to database.");
        }
    }//Adds an entry to Competitions table every time a user submits a song

    /**
     *
     * @param i
     * @param user2
     * @param song2
     * @param winner
     * Updates a competition that does not yet have a second user
     */
    public void updateCompetition(int i, String user2, String song2, String 
            winner) {
        try {
            String sql = "UPDATE "
                    + "Competitions SET User2 = '" + user2 + "', Song2 = '"
                    + song2 + "', Winner = '" + winner + "' WHERE "
                    + "CompetitionID = " + i;

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error while adding competition to database.");
        }
    }

    /**
     *
     * @param compID
     * @param winner
     * Assigns a winner to a competition in the Competitions table
     */
    public void addWinner(int compID, String winner) {
        try {
            String sql = "UPDATE Competitions SET Winner = '" + winner + "' "
                    + "WHERE CompetitionID = " + compID;
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error while assigning winner in table Compe"
                    + "titions");
        }
    }
 
    /**
     *
     * @param compID
     * @param username
     * @param score
     * Updates a user's score by 10 if they won a competition
     */
    public void updateScore(int compID, String username, int score) {
        try {
            String sql = "UPDATE Users SET Score = " + score + 10 + "WHERE "
                    + "CompetitionID = " + compID;
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error while updating score.");
        }
    }

    /**
     *
     * @param i
     * @param votesFor1
     * @param votesFor2
     * Updates the votes in a competition when a user votes for a song on the
     * Voting Screen
     */
    public void updateVotes(int i, int votesFor1, int votesFor2) {
        try {
            String sql = "UPDATE Competitions SET Votesfor1 = " + votesFor1 
                    + ", Votesfor2 = " + votesFor2 + " WHERE CompetitionID "
                    + "= " + i;

            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error while updating votes in database.");
        }
    }

    /**
     *
     * @param compID
     * @param voter
     * @param selection
     * Adds a user as a voter in the Voters table once they have voted for a 
     * competition.
     */
    public void addVoter(int compID, String voter, int selection) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("INSERT "
                    + "INTO Voters(CompetitionID, VoterUsername, Selection)"
                    + " VALUES (?,?,?)");

            pStatement.setInt(1, compID);
            pStatement.setString(2, voter);
            pStatement.setInt(3, selection);

            pStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error while adding voter to database.");
        }
    }

    /**
     *
     * @param soundName
     * @param username
     * Adds a voice recording to the uploads table if a user has decided to
     * record their own voice.
     */
    public void addUpload(String soundName, String username) {
        try {
            String sql = "INSERT INTO Uploads(SoundID, SoundName, Username)"
                   + " VALUES (" + 7 + ",' " + soundName + "', '" + username + 
                    "')";
            
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error while adding upload to database.");
        }
    }

    /**
     *
     * @param username
     * @param friendUsername
     * Adds a user as the current user's friend in the Friends table
     */
    public void addFriend(String username, String friendUsername) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("INSERT "
                    + "INTO Friends(Username, FriendUsername) VALUES (?,?)");
            pStatement.setString(1, username);
            pStatement.setString(2, friendUsername);

            pStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error while adding friend to database.");
        }
    }

    /**
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet runSelect(String sql) throws SQLException {
        resultSet = stmt.executeQuery(sql);
        return resultSet;
    }

    /**
     *Closes the database
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error closing database");
        }
    }
    
  

}
