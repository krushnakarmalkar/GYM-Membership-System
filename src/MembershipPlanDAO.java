import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipPlanDAO {


    public boolean addPlan(MembershipPlan plan) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO membership_plans (name, duration_months, price) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, plan.getName());
            stmt.setInt(2, plan.getDurationMonths());
            stmt.setDouble(3, plan.getPrice());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error adding plan: " + e.getMessage());
            return false;
        }
    }

    public List<String> getAllPlans() {
        List<String> plans = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM membership_plans";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                plans.add(rs.getInt("plan_id") + ". " +
                        rs.getString("name") + ", " +
                        rs.getInt("duration_months") + " months, ₹" +
                        rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching plans: " + e.getMessage());
        }
        return plans;
    }
}
