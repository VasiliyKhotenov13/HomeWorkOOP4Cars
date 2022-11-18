package Driver;

import Transport.Car;

public class DriverB extends Drivers<Car>{

    public DriverB(String fullName, String driverLicence, int experience, Car car) {
        super(fullName, driverLicence, experience, car);
    }
}
