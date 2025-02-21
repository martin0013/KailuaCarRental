import java.sql.Date;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String fuelType;
    private String registrationNumber;
    private Date firstRegistrationDate;
    private int odometer;
    private String category;

    // Konstruktør til at oprette en bil med alle parametre
    public Car(int id, String brand, String model, String fuelType, String registrationNumber, Date firstRegistrationDate, int odometer, String category) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.registrationNumber = registrationNumber;
        this.firstRegistrationDate = firstRegistrationDate;
        this.odometer = odometer;
        this.category = category;
    }

    // Tom konstruktør til JDBC
    public Car() {}

    // Returnerer bilens ID
    public int getId() {
        return id;
    }

    // Returnerer bilens mærke
    public String getBrand() {
        return brand;
    }

    // Returnerer bilens model
    public String getModel() {
        return model;
    }

    // Returnerer bilens brændstoftype
    public String getFuelType() {
        return fuelType;
    }

    // Returnerer bilens registreringsnummer
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    // Returnerer bilens første registreringsdato
    public Date getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    // Returnerer bilens kilometerstand
    public int getOdometer() {
        return odometer;
    }

    // Returnerer bilens kategori
    public String getCategory() {
        return category;
    }

    // Returnerer en strengrepræsentation af bilen
    @Override
    public String toString() {
        return "ID: " + id + " | Mærke: " + brand + " | Model: " + model +
                " | Brændstof: " + fuelType + " | RegNr: " + registrationNumber +
                " | Km: " + odometer + " | Kategori: " + category;
    }
}
