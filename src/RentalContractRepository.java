import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalContractRepository {
    private final String url = "jdbc:mysql://localhost:3306/kailua_carrental";
    private final String user = "root";
    private final String password = "";

    // Tilføj en ny lejekontrakt
    public void insertRentalContract(int customerID, int carID, Date rentalDate, Date returnDate, int maxKm, int odometerAtStart, String regNumber) {
        String sql = "INSERT INTO RentalContract (customerID, carID, rentalDate, returnDate, maxKm, odometerAtStart, regNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerID);
            stmt.setInt(2, carID);
            stmt.setDate(3, rentalDate);
            stmt.setDate(4, returnDate);
            stmt.setInt(5, maxKm);
            stmt.setInt(6, odometerAtStart);
            stmt.setString(7, regNumber);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hent alle lejekontrakter
    public List<String> getAllRentalContracts() {
        List<String> contracts = new ArrayList<>();
        String sql = "SELECT * FROM RentalContract";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String contract = "ID: " + rs.getInt("id") + ", Kunde-ID: " + rs.getInt("customerID") + ", Bil-ID: " + rs.getInt("carID")
                        + ", Lejedato: " + rs.getDate("rentalDate") + ", Returneringsdato: " + rs.getDate("returnDate");
                contracts.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }

    // Opdater lejekontrakt (fx opdatere maksimal km)
    public void updateRentalContract(int contractID, int newMaxKm) {
        String sql = "UPDATE RentalContract SET maxKm = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newMaxKm);
            stmt.setInt(2, contractID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Slet en lejekontrakt
    public void deleteRentalContract(int contractID) {
        String sql = "DELETE FROM RentalContract WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, contractID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
