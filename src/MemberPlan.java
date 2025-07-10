import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberPlan {
    public boolean assignPlanToMember(int memberId, int planId, String startDate) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO member_plan (member_id, plan_id, start_date) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, memberId);
            stmt.setInt(2, planId);
            stmt.setString(3, startDate); // Format: "YYYY-MM-DD"

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println(" Error assigning plan: " + e.getMessage());
            return false;
        }
    }
}
