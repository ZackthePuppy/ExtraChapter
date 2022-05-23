import java.sql.*;
import java.util.Scanner;

public class MySQLProcess {

    // initialization for mysql used for connection later

    private String dbURL = "jdbc:mysql://localhost:3306/";
    private String dbName = "santos_burger";
    private final String USER = "root";
    private final String PASS = "";

    private DisplayDesign go = new DisplayDesign();
    private String id, itemname, price, stock;

    public void addBurger() {
        go.clearConsole();
        Scanner sc = new Scanner(System.in);
        String burgerName;
        int price, stock;

        System.out.print("Burger Name: ");
        burgerName = sc.next();

        System.out.print("Price: ");
        price = sc.nextInt();

        System.out.print("Stock: ");
        stock = sc.nextInt();


        
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(dbURL + dbName, USER, PASS);

            stmt = conn.createStatement();
            String sql = "select * from items";
            stmt.executeUpdate(sql);

            // Query results
            System.out.printf("%-7s %-20s %-10s %-10s",
                    "ID #", "ITEMNAME", "PRICE", "STOCK");
            System.out.println();

            // Disconnect database
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            // JDBC error
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the database connection again
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }


    }




    public void viewAll() { // DISPLAYS ALL RESULTS FROM YOUR DATABASE TABLE
        go.clearConsole();
        go.printBox("LIST OF BURGERS");

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(dbURL + dbName, USER, PASS);

            stmt = conn.createStatement();
            String sql = "select * from items";
            ResultSet rs = stmt.executeQuery(sql);

            // Query results
            System.out.printf("%-7s %-20s %-10s %-10s",
                    "ID #", "ITEMNAME", "PRICE", "STOCK");
            System.out.println();
            while (rs.next()) {

                // The field type needs to be specified
                id = rs.getString("id");
                itemname = rs.getString("itemname");
                price = rs.getString("price");
                stock = rs.getString("stock");

                // Print information
                System.out.printf("%-7s %-20s %-10s %-10s", id, itemname, price, stock);
                System.out.println();
            }

            // Disconnect database
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            // JDBC error
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the database connection again
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }

    }

}
