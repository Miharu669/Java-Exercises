package dev.vero.automovil;

import dev.vero.automovil.enums.CarType;
import dev.vero.automovil.enums.Color;
import dev.vero.automovil.enums.FuelType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Toyota", 2020, 2.0, FuelType.GASOLINE, CarType.SUV, 4, 5, 200, Color.BLUE, true);
    }

    @Test
    void testGettersAndSetters() {
        car.setBrand("Honda");
        assertEquals("Honda", car.getBrand());

        car.setModelYear(2021);
        assertEquals(2021, car.getModelYear());

        car.setEngineDisplacement(2.5);
        assertEquals(2.5, car.getEngineDisplacement());

        car.setFuelType(FuelType.DIESEL);
        assertEquals(FuelType.DIESEL, car.getFuelType());

        car.setCarType(CarType.COMPACT);
        assertEquals(CarType.COMPACT, car.getCarType());

        car.setNumberOfDoors(2);
        assertEquals(2, car.getNumberOfDoors());

        car.setNumberOfSeats(4);
        assertEquals(4, car.getNumberOfSeats());

        car.setMaxSpeed(220);
        assertEquals(220, car.getMaxSpeed());

        car.setColor(Color.RED);
        assertEquals(Color.RED, car.getColor());

        car.setCurrentSpeed(80);
        assertEquals(80, car.getCurrentSpeed());

        car.setAutomatic(false);
        assertFalse(car.isAutomatic());

        car.setFines(50);
        assertEquals(50, car.getFines());
    }

    @Test
    void testAccelerate() {
        car.accelerate(50);
        assertEquals(50, car.getCurrentSpeed());

        car.accelerate(200);
        assertEquals(200, car.getMaxSpeed());
        assertEquals(100, car.getFines());
    }

    @Test
    void testDecelerate() {
        car.setCurrentSpeed(100);
        car.decelerate(50);
        assertEquals(50, car.getCurrentSpeed());

        car.decelerate(100);
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void testBrake() {
        car.setCurrentSpeed(100);
        car.brake();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void testCalculateEstimatedArrivalTime() {
        car.setCurrentSpeed(100);
        double arrivalTime = car.calculateEstimatedArrivalTime(200);
        assertEquals(2, arrivalTime);

        car.setCurrentSpeed(0);
        arrivalTime = car.calculateEstimatedArrivalTime(200);
        assertEquals(-1, arrivalTime);
    }

    @Test
    void testDisplayAttributes() {

        car.displayAttributes();
    }

    @Test
    void testFinesWhenSpeedExceedsMaxSpeed() {
        car.setCurrentSpeed(190);
        car.accelerate(15);
        assertEquals(200, car.getCurrentSpeed());
        assertEquals(100, car.getFines());
    }

    @Test
    void testMultipleFinesAccumulation() {
        car.setCurrentSpeed(190);
        car.accelerate(15);
        assertEquals(200, car.getCurrentSpeed());
        assertEquals(100, car.getFines());

        car.setCurrentSpeed(190);
        car.accelerate(15);
        assertEquals(200, car.getCurrentSpeed());
        assertEquals(200, car.getFines());
    }

    @Test
    void testNoFineWhenSpeedDoesNotExceedMaxSpeed() {
        car.setCurrentSpeed(150);
        car.accelerate(30);
        assertEquals(180, car.getCurrentSpeed());
        assertEquals(0, car.getFines());
    }

    @Test
    void testFineReset() {
        car.setFines(100);
        car.setFines(0);
        assertEquals(0, car.getFines());
    }
}
