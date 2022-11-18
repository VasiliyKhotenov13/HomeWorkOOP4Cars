package Driver;

import Transport.Bus;

public class DriverC extends Drivers<Bus> {

    public DriverC(String fullName, String driverLicence, int experience, Bus car) {
        super(fullName, driverLicence, experience, car);
    }
}
