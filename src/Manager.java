import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private final CarRepository carRepo = new CarRepository(); // Objekt til databasehåndtering af biler
    private final CustomerRepository customerRepo = new CustomerRepository(); // Objekt til databasehåndtering af kunder
    private final RentalContractRepository rentalRepo = new RentalContractRepository(); // Objekt til databasehåndtering af lejekontrakter
    private final Scanner scanner = new Scanner(System.in); // Scanner til brugerinput

    // Starter programmet og viser menuen
    public void start() {
        while (true) {
            System.out.println("\n--- VELKOMMEN TIL KAILUA CAR RENTAL ---");
            System.out.println("1. Håndter biler");
            System.out.println("2. Håndter kunder");
            System.out.println("3. Håndter lejekontrakter");
            System.out.println("4. Afslut");
            System.out.print("Vælg en handling: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Ryd scanner bufferen

            switch (choice) {
                case 1 -> carMenu();
                case 2 -> customerMenu();
                case 3 -> rentalMenu();
                case 4 -> {
                    System.out.println("Programmet afsluttes...");
                    return;
                }
                default -> System.out.println("Ugyldigt valg, prøv igen.");
            }
        }
    }

    // Viser menuen for bilhåndtering
    private void carMenu() {
        System.out.println("\n--- HÅNDTER BILER ---");
        System.out.println("1. Tilføj bil");
        System.out.println("2. Vis alle biler");
        System.out.println("3. Opdater kilometerstand");
        System.out.println("4. Slet bil");
        System.out.println("5. Tilbage til hovedmenu");
        System.out.print("Vælg en handling: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Ryd scanner bufferen

        switch (choice) {
            case 1 -> addCar();
            case 2 -> listCars();
            case 3 -> updateOdometer();
            case 4 -> deleteCar();
            case 5 -> {
                return;
            }
            default -> System.out.println("Ugyldigt valg, prøv igen.");
        }
    }

    // Tilføjer en ny bil til databasen
    private void addCar() {
        System.out.print("Mærke: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Brændstoftype: ");
        String fuelType = scanner.nextLine();
        System.out.print("Registreringsnummer: ");
        String regNumber = scanner.nextLine();
        System.out.print("Første registreringsdato (YYYY-MM-DD): ");
        String firstReg = scanner.nextLine();
        System.out.print("Kilometerstand: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Kategori (Luxury, Family, Sport): ");
        String category = scanner.nextLine();

        carRepo.insertCar(brand, model, fuelType, regNumber, Date.valueOf(firstReg), odometer, category);
        System.out.println("Bilen er tilføjet til databasen.");
    }

    // Viser en liste over alle biler
    private void listCars() {
        List<String> cars = carRepo.getAllCars();
        if (cars.isEmpty()) {
            System.out.println("Ingen biler fundet.");
        } else {
            System.out.println("\n--- Liste over biler ---");
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }

    // Opdaterer kilometerstand for en bil
    private void updateOdometer() {
        System.out.print("Indtast bil-ID: ");
        int carID = scanner.nextInt();
        System.out.print("Ny kilometerstand: ");
        int newOdometer = scanner.nextInt();
        carRepo.updateOdometer(carID, newOdometer);
        System.out.println("Kilometerstanden er opdateret.");
    }

    // Sletter en bil fra databasen
    private void deleteCar() {
        System.out.print("Indtast bil-ID på den bil, der skal slettes: ");
        int deleteCarID = scanner.nextInt();
        carRepo.deleteCar(deleteCarID);
        System.out.println("Bilen er slettet fra databasen.");
    }

    // Viser menuen for kunde håndtering
    private void customerMenu() {
        System.out.println("\n--- HÅNDTER KUNDER ---");
        System.out.println("1. Tilføj kunde");
        System.out.println("2. Vis alle kunder");
        System.out.println("3. Opdater kundes telefonnummer");
        System.out.println("4. Slet kunde");
        System.out.println("5. Tilbage til hovedmenu");
        System.out.print("Vælg en handling: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Ryd scanner bufferen

        switch (choice) {
            case 1 -> addCustomer();
            case 2 -> listCustomers();
            case 3 -> updateCustomerPhone();
            case 4 -> deleteCustomer();
            case 5 -> {
                return;
            }
            default -> System.out.println("Ugyldigt valg, prøv igen.");
        }
    }

    // Tilføjer en ny kunde
    private void addCustomer() {
        System.out.print("Navn: ");
        String name = scanner.nextLine();
        System.out.print("Adresse: ");
        String address = scanner.nextLine();
        System.out.print("Postnummer: ");
        String zip = scanner.nextLine();
        System.out.print("By: ");
        String city = scanner.nextLine();
        System.out.print("Mobiltelefon: ");
        String mobilePhone = scanner.nextLine();
        System.out.print("Telefonnummer: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Kørekortnummer: ");
        String driverLicenceNumber = scanner.nextLine();
        System.out.print("Kørekort startdato (YYYY-MM-DD): ");
        String driverSinceDate = scanner.nextLine();

        customerRepo.insertCustomer(name, address, zip, city, mobilePhone, phone, email, driverLicenceNumber, driverSinceDate);
        System.out.println("Kunden er tilføjet til databasen.");
    }

    // Viser en liste over alle kunder
    private void listCustomers() {
        List<String> customers = customerRepo.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("Ingen kunder fundet.");
        } else {
            System.out.println("\n--- Liste over kunder ---");
            for (String customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // Opdaterer telefonnummer for en kunde
    private void updateCustomerPhone() {
        System.out.print("Indtast kunde-ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine(); // Ryd scanner bufferen
        System.out.print("Indtast nyt telefonnummer: ");
        String newPhone = scanner.nextLine();
        customerRepo.updateCustomerPhone(customerID, newPhone);
        System.out.println("Telefonnummeret er opdateret.");
    }

    // Sletter en kunde
    private void deleteCustomer() {
        System.out.print("Indtast kunde-ID for den kunde, der skal slettes: ");
        int customerID = scanner.nextInt();
        customerRepo.deleteCustomer(customerID);
        System.out.println("Kunden er slettet fra databasen.");
    }

    // Viser menuen for lejekontrakt håndtering
    private void rentalMenu() {
        System.out.println("\n--- HÅNDTER LEJEKONTRAKTER ---");
        System.out.println("1. Opret lejekontrakt");
        System.out.println("2. Vis alle lejekontrakter");
        System.out.println("3. Opdater lejekontrakt");
        System.out.println("4. Slet lejekontrakt");
        System.out.println("5. Tilbage til hovedmenu");
        System.out.print("Vælg en handling: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Ryd scanner bufferen

        switch (choice) {
            case 1 -> addRentalContract();
            case 2 -> listRentalContracts();
            case 3 -> updateRentalContract();
            case 4 -> deleteRentalContract();
            case 5 -> {
                return;
            }
            default -> System.out.println("Ugyldigt valg, prøv igen.");
        }
    }

    // Opretter en ny lejekontrakt
    private void addRentalContract() {
        System.out.print("Kunde-ID: ");
        int customerID = scanner.nextInt();
        System.out.print("Bil-ID: ");
        int carID = scanner.nextInt();
        System.out.print("Lejedato (YYYY-MM-DD): ");
        String rentalDate = scanner.next();
        System.out.print("Returneringsdato (YYYY-MM-DD): ");
        String returnDate = scanner.next();
        System.out.print("Maksimum km: ");
        int maxKm = scanner.nextInt();
        System.out.print("Odometer ved start: ");
        int odometerAtStart = scanner.nextInt();
        System.out.print("Registreringsnummer: ");
        String regNumber = scanner.next();

        rentalRepo.insertRentalContract(customerID, carID, Date.valueOf(rentalDate), Date.valueOf(returnDate), maxKm, odometerAtStart, regNumber);
        System.out.println("Lejekontrakten er oprettet.");
    }

    // Viser en liste over alle lejekontrakter
    private void listRentalContracts() {
        List<String> contracts = rentalRepo.getAllRentalContracts();
        if (contracts.isEmpty()) {
            System.out.println("Ingen lejekontrakter fundet.");
        } else {
            System.out.println("\n--- Liste over lejekontrakter ---");
            for (String contract : contracts) {
                System.out.println(contract);
            }
        }
    }

    // Opdaterer en lejekontrakt
    private void updateRentalContract() {
        System.out.print("Indtast lejekontrakt-ID: ");
        int contractID = scanner.nextInt();
        System.out.print("Indtast ny maksimale kilometer: ");
        int newMaxKm = scanner.nextInt();
        rentalRepo.updateRentalContract(contractID, newMaxKm);
        System.out.println("Lejekontrakten er opdateret.");
    }

    // Sletter en lejekontrakt
    private void deleteRentalContract() {
        System.out.print("Indtast lejekontrakt-ID: ");
        int contractID = scanner.nextInt();
        rentalRepo.deleteRentalContract(contractID);
        System.out.println("Lejekontrakten er slettet.");
    }

    // Main-metode til at starte programmet
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.start(); // Starter programmet
    }
}
