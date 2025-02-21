public class Customer {
    private int id;
    private String name;
    private String address;
    private String zip;
    private String city;
    private String mobilePhone;
    private String phone;
    private String email;
    private String driverLicenceNumber;
    private String driverSinceDate;

    // Konstruktør til at oprette en kunde med alle parametre
    public Customer(int id, String name, String address, String zip, String city, String mobilePhone, String phone, String email, String driverLicenceNumber, String driverSinceDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.mobilePhone = mobilePhone;
        this.phone = phone;
        this.email = email;
        this.driverLicenceNumber = driverLicenceNumber;
        this.driverSinceDate = driverSinceDate;
    }

    // Tom konstruktør til JDBC
    public Customer() {}

    // Returnerer kundens ID
    public int getId() {
        return id;
    }

    // Returnerer kundens navn
    public String getName() {
        return name;
    }

    // Returnerer kundens adresse
    public String getAddress() {
        return address;
    }

    // Returnerer kundens postnummer
    public String getZip() {
        return zip;
    }

    // Returnerer kundens by
    public String getCity() {
        return city;
    }

    // Returnerer kundens mobilnummer
    public String getMobilePhone() {
        return mobilePhone;
    }

    // Returnerer kundens telefonnummer
    public String getPhone() {
        return phone;
    }

    // Returnerer kundens email
    public String getEmail() {
        return email;
    }

    // Returnerer kundens kørekortnummer
    public String getDriverLicenceNumber() {
        return driverLicenceNumber;
    }

    // Returnerer hvornår kunden fik kørekort
    public String getDriverSinceDate() {
        return driverSinceDate;
    }

    // Returnerer en strengrepræsentation af kunden
    @Override
    public String toString() {
        return "ID: " + id + " | Navn: " + name + " | Adresse: " + address +
                " | By: " + city + " | Telefon: " + mobilePhone + " | Email: " + email;
    }
}
