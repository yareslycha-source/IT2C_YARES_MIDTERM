package org.example.dao;

import org.example.model.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

    public void addMember(Member member) {
        String sql = "INSERT INTO members (full_name, tier, monthly_fee, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, member.getFullName());
            pstmt.setString(2, member.getTier());
            pstmt.setDouble(3, member.getMonthlyFee());
            pstmt.setString(4, member.getStatus());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding member: " + e.getMessage());
        }
    }

    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT id, full_name, tier, monthly_fee, status FROM members";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Member member = new Member(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("tier"),
                        rs.getDouble("monthly_fee"),
                        rs.getString("status")
                );
                members.add(member);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching members: " + e.getMessage());
        }
        return members;
    }
}