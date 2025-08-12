package com.library;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class Users_CRUD {
	public void addUser(User user) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO Users (name, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());

            stmt.executeUpdate();
            stmt.close();
            conn.close();

            System.out.println("✅ User added successfully!");
        } catch (Exception e) {
            System.out.println("❌ Failed to add user");
            e.printStackTrace();
        }
	}
        public List<User> getAllUsers() {
            List<User> users = new ArrayList<>();
            try {
                Connection conn = DBConnection.getConnection();
                String sql = "SELECT * FROM Users";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("user_id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    users.add(new User(id, name, email));
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("❌ Failed to fetch users");
                e.printStackTrace();
            }
            return users;
        }

        public void updateUser(User user) {
            try {
                Connection conn = DBConnection.getConnection();
                String sql = "UPDATE Users SET name=?, email=? WHERE user_id=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getEmail());
                stmt.setInt(3, user.getId());

                stmt.executeUpdate();
                stmt.close();
                conn.close();

                System.out.println("✅ User updated successfully!");
            } catch (Exception e) {
                System.out.println("❌ Failed to update user");
                e.printStackTrace();
            }
        }
        public void deleteUser(int id) {
            try {
                Connection conn = DBConnection.getConnection();
                String sql = "DELETE FROM Users WHERE user_id=?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);

                stmt.executeUpdate();
                stmt.close();
                conn.close();

                System.out.println("✅ User deleted successfully!");
            } catch (Exception e) {
                System.out.println("❌ Failed to delete user");
                e.printStackTrace();
            }
        }
    
   

}
