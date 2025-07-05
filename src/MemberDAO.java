import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public boolean addMember(Member member) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO members (name, age, gender, phone, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, member.getName());
            stmt.setInt(2, member.getAge());
            stmt.setString(3, member.getGender());
            stmt.setString(4, member.getPhone());
            stmt.setString(5, member.getEmail());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public List<String> getAllMembers() {
        List<String> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM members";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt("member_id") + ". " +
                        rs.getString("name") + ", " +
                        rs.getInt("age") + ", " +
                        rs.getString("gender") + ", " +
                        rs.getString("phone") + ", " +
                        rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching members: " + e.getMessage());
        }
        return list;
    }
}
