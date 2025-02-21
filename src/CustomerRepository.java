import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private final String url = "jdbc:mysql://localhost:3306/kailua_carrental";
    private final String user = "root";
    private final String password = "";

    // Tilføj en ny kunde
    public void insertCustomer(String name, String address, String zip, String city, String mobilePhone, String phone, String email, String driverLicenceNumber, String driverSinceDate) {
        String sql = "INSERT INTO Customer (name, address, zip, city, mobilePhone, phone, email, driverLicenceNumber, driverSinceDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, zip);
            stmt.setString(4, city);
            stmt.setString(5, mobilePhone);
            stmt.setString(6, phone);
            stmt.setString(7, email);
            stmt.setString(8, driverLicenceNumber);
            stmt.setString(9, driverSinceDate);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hent alle kunder
    public List<String> getAllCustomers() {
        List<String> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customer";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String customer = "ID: " + rs.getInt("id") + ", Navn: " + rs.getString("name") + ", By: " + rs.getString("city");
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Opdater en kundes telefonnummer
    public void updateCustomerPhone(int customerID, String newPhone) {
        String sql = "UPDATE Customer SET phone = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newPhone);
            stmt.setInt(2, customerID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Slet en kunde
    public void deleteCustomer(int customerID) {
        String sql = "DELETE FROM Customer WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
