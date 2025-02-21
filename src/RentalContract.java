import java.sql.Date;

public class RentalContract {
    private int rentalID;
    private int customerID;
    private int carID;
    private Date rentalDate;
    private Date returnDate;
    private int maxKm;
    private int odometerAtStart;
    private String registrationNumber;

    // Konstruktør til at oprette en ny lejekontrakt
    public RentalContract(int rentalID, int customerID, int carID, Date rentalDate, Date returnDate, int maxKm, int odometerAtStart, String registrationNumber) {
        this.rentalID = rentalID;
        this.customerID = customerID;
        this.carID = carID;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.maxKm = maxKm;
        this.odometerAtStart = odometerAtStart;
        this.registrationNumber = registrationNumber;
    }

    // Tom konstruktør til JDBC
    public RentalContract() {}

    // Returnerer lejekontraktens ID
    public int getRentalID() {
        return rentalID;
    }

    // Returnerer kundens ID
    public int getCustomerID() {
        return customerID;
    }

    // Returnerer bilens ID
    public int getCarID() {
        return carID;
    }

    // Returnerer datoen for lejestart
    public Date getRentalDate() {
        return rentalDate;
    }

    // Returnerer datoen for tilbagelevering
    public Date getReturnDate() {
        return returnDate;
    }

    // Returnerer det maksimale antal kilometer, der må køres
    public int getMaxKm() {
        return maxKm;
    }

    // Returnerer odometer læsningen ved start af lejeperioden
    public int getOdometerAtStart() {
        return odometerAtStart;
    }

    // Returnerer bilens registreringsnummer
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    // Returnerer en strengrepræsentation af lejekontrakten
    @Override
    public String toString() {
        return "Lejekontrakt ID: " + rentalID + " | Kunde ID: " + customerID +
                " | Bil ID: " + carID + " | Startdato: " + rentalDate + " | Slutdato: " + returnDate +
                " | Max km: " + maxKm + " | Odometer start: " + odometerAtStart;
    }
}
