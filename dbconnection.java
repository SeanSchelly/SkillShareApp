import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dbconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/skillshare_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void saveRequest(skrequest req) {
        String query = "INSERT INTO requests (sender, receiver, status, req_id, skill) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, req.getreqsender());
            ps.setString(2, req.getreqreciever());
            ps.setString(3, req.getstatus());
            ps.setInt(4, req.getreqid());
            ps.setString(5, req.getskill());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Database Insert Error (Request): " + e.getMessage());
        }
    }

    public static ArrayList<skrequest> loadRequests() {
        ArrayList<skrequest> list = new ArrayList<>();
        String query = "SELECT * FROM requests";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new skrequest(
                        rs.getString("sender"),
                        rs.getString("receiver"),
                        rs.getString("status"),
                        rs.getInt("req_id"),
                        rs.getString("skill")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Database Select Error (Request): " + e.getMessage());
        }
        return list;
    }

    public static void saveReview(reviews rev) {
        String query = "INSERT INTO reviews (rev_id, author, target, rating, comment) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, rev.getrevID());
            ps.setString(2, rev.getreviewauthor());
            ps.setString(3, rev.getreviewtarget());
            ps.setInt(4, rev.getuserrating());
            ps.setString(5, rev.getusercomment());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Database Insert Error (Review): " + e.getMessage());
        }
    }

    public static ArrayList<reviews> loadReviews() {
        ArrayList<reviews> list = new ArrayList<>();
        String query = "SELECT * FROM reviews";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new reviews(
                        rs.getInt("rev_id"),
                        rs.getString("author"),
                        rs.getString("target"),
                        rs.getInt("rating"),
                        rs.getString("comment")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Database Select Error (Review): " + e.getMessage());
        }
        return list;
    }
    // [Integration] Added saveUser / loadUsers for User persistence via database
    public static void saveUser(User user) {
        String query = "INSERT INTO users (id, name, email, password, role, rating) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, "");
            ps.setString(5, user.getRole());
            ps.setDouble(6, user.getRating());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Database Insert Error (User): " + e.getMessage());
        }
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> list = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        "",
                        rs.getString("role")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Database Select Error (User): " + e.getMessage());
        }
        return list;
    }
}