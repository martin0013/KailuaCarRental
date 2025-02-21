import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final String url = "jdbc:mysql://localhost:3306/kailua_carrental"; // database-URL
    private final String user = "root"; // Databasebrugernavn
    private final String password = ""; //

    // Metode til at indsætte en bil i databasen
    public void insertCar(String brand, String model, String fuelType, String regNumber, Date firstReg, int odometer, String category) {
        String sql = "INSERT INTO Car (brand, model, fuelType, registrationNumber, firstRegistrationDate, odometer, category) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, brand);
            stmt.setString(2, model);
            stmt.setString(3, fuelType);
            stmt.setString(4, regNumber);
            stmt.setDate(5, firstReg);
            stmt.setInt(6, odometer);
            stmt.setString(7, category);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode til at hente alle biler fra databasen
    public List<String> getAllCars() {
        List<String> cars = new ArrayList<>();
        String sql = "SELECT * FROM Car";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String car = "ID: " + rs.getInt("id") + ", Mærke: " + rs.getString("brand") +
                        ", Model: " + rs.getString("model") + ", Kilometerstand: " + rs.getInt("odometer");
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    // Metode til at opdatere en bils kilometerstand
    public void updateOdometer(int carID, int newOdometer) {
        String sql = "UPDATE Car SET odometer = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newOdometer);
            stmt.setInt(2, carID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metode til at slette en bil fra databasen
    public void deleteCar(int carID) {
        String sql = "DELETE FROM Car WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, carID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
