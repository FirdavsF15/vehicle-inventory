package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {

    static int counter = 0;

    private static Scanner scanner = new Scanner(System.in);

    static Vehicle[] cars = new Vehicle[20];

    public static void main(String[] args) {





        Vehicle car1 = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        cars[0] = car1;

        Vehicle car2 = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        cars[1] = car2;

        Vehicle car3 = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        cars[2] = car3;

        Vehicle car4 = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        cars[3] = car4;

        Vehicle car5 = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        cars[4] = car5;

        Vehicle car6 = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);
        cars[5] = car6;

        counter = 6;

        boolean cont = true;
        do{
            System.out.println("What do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.print("Enter your command: ");

            int command = Integer.parseInt(scanner.nextLine());

            switch(command){
                case 1:
                    listAllVehicles(cars);
                    System.out.println();
                    break;
                case 2:
                    findVehiclesByMakeModel(cars);
                    break;
                case 5:
                    addVehicle();
                    break;
                case 6:
                    cont = false;
                    System.out.println("\nHave a good day!");
                    break;
            }

        }while(cont);


    }

    public static void listAllVehicles(Vehicle[] cars){
        for (int i = 0; i < counter; i++) {
            System.out.println(cars[i].getColor() + " " + cars[i].getMakeModel());
        }
    }

    public static void findVehiclesByMakeModel(Vehicle[] cars){
        System.out.println("What make/model are you looking for? ");
        String model = scanner.nextLine();

        for (int i = 0; i < counter; i++) {
            if(cars[i].getMakeModel().equals(model)){
                System.out.println("\nCar found");
                System.out.println(cars[i].getVehicleId() + " " + cars[i].getMakeModel() + " $" + cars[i].getPrice() + "\n");
            }
        }

    }

    public static void addVehicle(){
        System.out.print("Enter Vehicle ID: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.print("Enter make/model: ");
        String model = scanner.nextLine();
        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();
        System.out.print("Enter odometer reading: ");
        int odometerReading = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle newCar = new Vehicle(id, model, color, odometerReading, price);
        cars[counter] = newCar;

        counter++;
    }



}
