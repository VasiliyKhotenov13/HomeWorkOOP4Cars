package Driver;

import Transport.Truck;

public class DriverD extends Drivers<Truck> {

    public DriverD(String fullName, String driverLicence, int experience, Truck car) {
        super(fullName, driverLicence, experience, car);
    }
}
