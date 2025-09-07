package com.solvd.logistic;
import com.solvd.logistic.enums.Gender;
import com.solvd.logistic.enums.ShippingStatus;
import com.solvd.logistic.enums.Zone;
import com.solvd.logistic.generic.GenericContainer;
import com.solvd.logistic.generic.QueueManager;
import com.solvd.logistic.generic.Storage;
import com.solvd.logistic.model.*;
import com.solvd.logistic.service.PriceCalculator;
import com.solvd.logistic.service.Route;
import com.solvd.logistic.service.Shipping;
import com.solvd.logistic.tracking.*;
import com.solvd.logistic.exceptions.*;
import com.solvd.logistic.wordcounter.WordCounterInFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final Logger SLOGGER = LogManager.getLogger("simpleLogger");
    private static QueueManager<Shipping> shippingManager = new QueueManager<>();
    private static Storage<String, Shipping> shippingStorage = new Storage<>();
    private static Set<Vehicle> vehicleFleet = new HashSet<>();
    private static List<Client> registeredClients = new ArrayList<>();
    private static int shippingCounter = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Interfaces
        ITimeProvider timeProvider = new SystemTimeProvider();
        IDisplayable display = new TrackingDisplay();

        // Predefined objects
        GenericContainer<Vehicle> defaultVehicle = new GenericContainer<>(new Truck("VGA-448", "Car", 120, true));
        Vehicle truck1 = new Truck("VGA-448", "Dry van", 2300, true);
        Vehicle truck2 = new Truck("ABC-123", "Reefer", 2500, false);
        Vehicle truck3 = new Truck("XYZ-987", "Flatbed", 2800, true);
        vehicleFleet.add(truck1);
        vehicleFleet.add(truck2);
        vehicleFleet.add(truck3);

        DistributionCenter center = new DistributionCenter("CentralGo", "Santander", "789 Warehouse Road", Zone.EAST);


        boolean running = true;

        while (running) {
            SLOGGER.info(" ");
            LOGGER.info("=== LOGISTICS SYSTEM ===");
            LOGGER.info("1. Register a new shipping");
            LOGGER.info("2. Check shipping status");
            LOGGER.info("3. Track a shipping");
            LOGGER.info("4. Register a client");
            LOGGER.info("5. Word count from a file");
            LOGGER.info("6. Exit");
            LOGGER.info("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {

                case "1":
                    // --- Register new shipping ---
                    LOGGER.info("\n--- New Shipping ---");

                    // Sender
                    SLOGGER.info("Sender name: ");
                    String senderName = scanner.nextLine();

                    SLOGGER.info("Sender address: ");
                    String senderAddress = scanner.nextLine();

                    SLOGGER.info("Sender ID: ");
                    String senderId = scanner.nextLine();

                    Client sender = new Client(senderName, senderAddress, null, Gender.NA);

                    try{
                        sender.setAddress(senderAddress);
                    }catch(InvalidAddressException e){
                        LOGGER.info("INVALID address assign: {}", e.getMessage());
                        break;
                    }

                    try{
                        sender.setId(senderId);
                    }catch (InvalidIDException e){
                        LOGGER.info("INVALID ID assign: {}", e.getMessage());
                        break;
                    }

                    // Receiver
                    SLOGGER.info("Receiver name: ");
                    String receiverName = scanner.nextLine();

                    SLOGGER.info("Receiver address: ");
                    String receiverAddress = scanner.nextLine();

                    SLOGGER.info("Receiver ID: ");
                    String receiverId = scanner.nextLine();

                    Client receiver = new Client(receiverName, receiverAddress, null, Gender.NA);
                    try{
                        sender.setAddress(senderAddress);
                    }catch(InvalidAddressException e){
                        LOGGER.info("INVALID address assign : {}", e.getMessage());
                        break;
                    }

                    try{
                        receiver.setId(receiverId);
                    }catch (InvalidIDException e){
                        LOGGER.info("INVALID assign : {}", e.getMessage());
                        break;
                    }

                    // Package
                    SLOGGER.info("Package description: ");
                    String description = scanner.nextLine();

                    SLOGGER.info("Package weight (lb): ");
                    double weight = Double.parseDouble(scanner.nextLine());

                    String shippingNumber = "SHP" + shippingCounter++;
                    GenericContainer<StandartPackage> packageContainer = new GenericContainer<>(new StandartPackage(shippingNumber, (double) 0, description));
                    StandartPackage pack = packageContainer.getItem();

                    try {
                        pack.setWeight(weight);
                    } catch (InvalidWeightException e){
                        LOGGER.info("INVALID Weight {}", String.valueOf(e));
                        break;
                    }

                    // Route (dummy)
                    Route route;
                    try{
                        route = new Route(center.getAddress(), receiverAddress, 120.0, "A508");
                    }catch (RouteNotFoundException e){
                        LOGGER.info(e.getMessage());
                        break;
                    }


                    // Calculate price
                    double price = PriceCalculator.computePrice(pack.getWeight(), route.getDistance());

                    // Shipping
                    Shipping shipping = new Shipping("5/10",sender, receiver, pack, defaultVehicle.getItem(), ShippingStatus.PENDING);
                    shippingStorage.add(shippingNumber, shipping);
                    shippingManager.enqueue(shipping);

                    SLOGGER.info(" ");
                    LOGGER.info("Shipping registered successfully.");
                    SLOGGER.info("Shipping number: {}", shippingNumber);
                    SLOGGER.info("Estimated price: ${}", price);
                    break;


                case "2":
                    // --- Check shipping status ---
                    SLOGGER.info("Enter shipping number (e.g., SHP1): ");
                    String searchNumber = scanner.nextLine();
                    try{
                        Shipping s = shippingStorage.get(searchNumber);
                        SLOGGER.info("-SHIPPING INFORMATION-");
                        LOGGER.info(s);
                    }catch(ShippingNotFoundException e){
                        LOGGER.info(e.getMessage());
                        break;
                    }
                    break;

                case "3":
                    // --- Track a shipping ---
                    SLOGGER.info("Enter shipping number to track (e.g., SHP1): ");
                    String trackNumber = scanner.nextLine();
                    Shipping shippingToTrack;
                    try {
                        shippingToTrack = shippingStorage.get(trackNumber);
                    }catch (ShippingNotFoundException e){
                        LOGGER.info(e.getMessage());
                        break;
                    }


                        ITrackable trackedPackage = new TrackedPackage(shippingToTrack.getPack().getShipNumber());
                        LOGGER.info("Starting tracking for {}", trackedPackage.getTrackId());
                        Stack<String> statusHistory = new Stack<>();

                        // Simulate package journey
                        ILocationProvider locationProvider = new SimpleLocationProvider();
                        while (locationProvider.hasMoreLocations()) {
                            String currentTime = timeProvider.getCurrentTime();
                            String currentLocation = locationProvider.getCurrentLocation();

                            trackedPackage.updateStatus("In transit, at " + currentLocation);
                            statusHistory.push(trackedPackage.getPackageStatus());
                            LOGGER.info("Package {} status updated at {}", trackedPackage.getTrackId(), currentTime);

                            display.display("Tracking ID: " + trackedPackage.getTrackId() + " | Status: " + trackedPackage.getPackageStatus());

                            try {
                                Thread.sleep(1000); //
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        // Final destination reached
                        String finalTime = timeProvider.getCurrentTime();
                        trackedPackage.updateStatus("Delivered");
                        statusHistory.push(trackedPackage.getPackageStatus());
                        LOGGER.info("Package {} has reached its final destination at {}", trackedPackage.getTrackId(), finalTime);
                        display.display("Tracking ID: " + trackedPackage.getTrackId() + " | Status: " + trackedPackage.getPackageStatus());
                    break;

                case "4":
                    LOGGER.info("Please enter the client's full name:");
                    String clientName = scanner.nextLine();

                    LOGGER.info("Please enter the client's address:");
                    String clientAddress = scanner.nextLine();

                    LOGGER.info("Please enter the client's ID:");
                    String clientId = scanner.nextLine();

                    LOGGER.info("Please enter the client's gender (MALE / FEMALE / NA):");
                    String genderInput = scanner.nextLine().toUpperCase(); //

                    try {
                        Gender gender = Gender.valueOf(genderInput);
                        Client newClient = new Client(clientName, clientAddress, null, gender);
                        newClient.setId(clientId);
                        newClient.setAddress(clientAddress);

                        registeredClients.add(newClient);
                        LOGGER.info("Client registered successfully: {}", newClient.getName());
                    } catch(InvalidAddressException | InvalidIDException e){
                        LOGGER.info("INVALID input: {}", e.getMessage());
                        break;
                    } catch (IllegalArgumentException e){
                        LOGGER.info("Invalid gender. Please try again ");
                        break;
                    }
                    break;
                case "5":
                    //Here
                    SLOGGER.info("Please enter the keyword to count");
                    String keyword = scanner.nextLine();
                    try {
                        WordCounterInFile.countWord(keyword, "text.txt", "count_results.txt");
                    } catch (IOException e){
                        LOGGER.info(e.getMessage());
                        break;
                    }
                    SLOGGER.info("Counter of keyword {} has been successfully written !", keyword);
                    break;
                case "6":
                    running = false;
                    LOGGER.info("Goodbye");
                    break;
                default:
                    LOGGER.info("Invalid option");
            }
        }
        scanner.close();
    }
}
