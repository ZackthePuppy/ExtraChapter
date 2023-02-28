import java.sql.*;

public class Process {

    public void processQuery(String query) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/santos_burger", "root", "");
                Statement stmt = conn.createStatement();) {

            int result = stmt.executeUpdate(query); // executes a query based on the given value in the parameter

            // if (result == 0) {
            // System.out.println("Error! No affected rows.");
            // } else {
            System.out.println(result + " row affected. Process successfully completed!");
            // }

        } catch (SQLException e) { // handles errors when you sell too much
            System.out.println("INVALID! Insufficient Stock");
        }

    }

    public String searchQuery(int id) { // for searching specific item in query, then returns a string to print it
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/santos_burger", "root", "");
                Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery("select itemname from items where id = " + id);

            if (rs.next() == true) {
                return rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }

    public void viewQuery() { // just for viewing all items in the table
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/santos_burger", "root", "");
                Statement stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery("select * from items");

            System.out.printf("%-5s %-15s %8s %8s\n", "ID#", "BURGERNAME", "PRICE", "QUANTITY");
            while (rs.next()) {
                System.out.printf("%-5s %-15s %8s %8s\n", rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}