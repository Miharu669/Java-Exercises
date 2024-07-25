package dev.vero.automovil;

import dev.vero.automovil.enums.*;

public class Car {

    private String brand;
    private int modelYear;
    private double engineDisplacement;
    private FuelType fuelType;
    private CarType carType;
    private int numberOfDoors;
    private int numberOfSeats;
    private double maxSpeed;
    private Color color;
    private double currentSpeed;
    private boolean isAutomatic;
    private double fines;

    public Car(String brand, int modelYear, double engineDisplacement, FuelType fuelType, CarType carType,
            int numberOfDoors, int numberOfSeats, double maxSpeed, Color color, boolean isAutomatic) {
        this.brand = brand;
        this.modelYear = modelYear;
        this.engineDisplacement = engineDisplacement;
        this.fuelType = fuelType;
        this.carType = carType;
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.isAutomatic = isAutomatic;
        this.currentSpeed = 0;
        this.fines = 0;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    public double getFines() {
        return fines;
    }

    public void setFines(double fines) {
        this.fines = fines;
    }

    public void accelerate(double increment) {
        if (currentSpeed + increment > maxSpeed) {
            fines += 100;
            System.out.println("Speed limit exceeded. Fine applied: 100");
            currentSpeed = maxSpeed;
        } else {
            currentSpeed += increment;
        }
        System.out.println("Current speed: " + currentSpeed + " km/h");
    }

    public void decelerate(double decrement) {
        if (currentSpeed - decrement < 0) {
            currentSpeed = 0;
            System.out.println("Speed cannot be negative. Current speed set to 0.");
        } else {
            currentSpeed -= decrement;
        }
        System.out.println("Current speed: " + currentSpeed + " km/h");
    }

    public void brake() {
        currentSpeed = 0;
        System.out.println("Car stopped. Current speed: 0 km/h");
    }

    public double calculateEstimatedArrivalTime(double distance) {
        if (currentSpeed == 0) {
            System.out.println("Current speed is 0. Cannot calculate arrival time.");
            return -1;
        }
        return distance / currentSpeed;
    }

    public void displayAttributes() {
        System.out.println("Brand: " + brand);
        System.out.println("Model Year: " + modelYear);
        System.out.println("Engine Displacement: " + engineDisplacement + " liters");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Car Type: " + carType);
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Number of Seats: " + numberOfSeats);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
        System.out.println("Color: " + color);
        System.out.println("Current Speed: " + currentSpeed + " km/h");
        System.out.println("Automatic: " + (isAutomatic ? "Yes" : "No"));
        System.out.println("Total Fines: " + fines);
    }

    public static void main(String[] args) {

        Car car = new Car("Toyota", 2020, 2.0, FuelType.GASOLINE, CarType.SUV,
                4, 5, 200, Color.BLUE, true);

        car.setCurrentSpeed(100);
        System.out.println("Initial speed: " + car.getCurrentSpeed() + " km/h");

        car.accelerate(20);

        car.decelerate(50);

        car.brake();

        car.displayAttributes();

        double distance = 150;
        double arrivalTime = car.calculateEstimatedArrivalTime(distance);
        if (arrivalTime != -1) {
            System.out.println("Estimated arrival time: " + arrivalTime + " hours");
        }
    }
}
