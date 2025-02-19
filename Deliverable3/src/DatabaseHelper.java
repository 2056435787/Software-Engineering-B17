import java.sql.*;

public class DatabaseHelper {
    private String url = "jdbc:mysql://localhost:3306/cinema_db";  // Change to your database URL
    private String user = "root";  // Your MySQL username
    private String password = "mysqlpass";  // Your MySQL password

    // Method to execute SQL command
    public void executeSqlCommand(String sql) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Check if the command is a SELECT query
            if (sql.trim().toUpperCase().startsWith("SELECT")) {
                try (PreparedStatement stmt = conn.prepareStatement(sql);
                     ResultSet resultSet = stmt.executeQuery()) {

                    // Print SQL-like table headers
                    System.out.printf("| %-2s | %-20s | %-15s | %-30s | %-20s | %-20s | %-8s | %-10s | %-8s |%n",
                            "ID", "Title", "Category", "Director", "Producer", "Cast", "Rating", "Show Date", "Show Time");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

                    // Display the results of the SELECT query
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String title = resultSet.getString("title");
                        String category = resultSet.getString("category");
                        String director = resultSet.getString("director");
                        String producer = resultSet.getString("producer");
                        String cast = resultSet.getString("cast");
                        String rating = resultSet.getString("rating");
                        String showDate = resultSet.getString("show_date");
                        String showTime = resultSet.getString("show_time");

                        // Print each row formatted like an SQL result
                        System.out.printf("| %-2d | %-20s | %-15s | %-30s | %-20s | %-20s | %-8s | %-10s | %-8s |%n",
                                id, title, category, director, producer, cast, rating, showDate, showTime);
                    }
                }
            } else {
                // For non-SELECT queries (INSERT, UPDATE, DELETE)
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    int rowsAffected = stmt.executeUpdate();
                    System.out.println(rowsAffected + " row(s) affected.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL command: " + e.getMessage());
        }
    }
}
