package Transport;

import Driver.Drivers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Transport {

    protected String brand;
    protected String model;
    protected double engineVolume;

    private final List<Drivers<?>> drivers = new ArrayList<>() ;
    private final List<Mechanic<?>> mechanics = new ArrayList<>() ;
    private final List<Sponsor> sponsors = new ArrayList<>() ;


    public Transport(String brand, String model, double engineVolume) {
        if (brand == null || brand.length() == 0) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.length() == 0) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (engineVolume <= 0) {
            this.engineVolume = 1.5f;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public List<Drivers<?>> getDrivers() {
        return drivers;
    }

    public List<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract boolean service();

    public void addDriver(Drivers<?> drivers) {
        drivers.add(drivers);
    }
    public void addMechanic(Mechanic<?> mechanic) {
        mechanics.add(mechanic);
    }
    public void addSponsor(Sponsor sponsor) {
        sponsors.add(sponsor);
    }

    @Override
    public String toString() {
        return "Транспорт. " +
                " Марка: " + brand +
                ". Модель: " + model +
                ". Объём двигателя: " + engineVolume + " л.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }

    public abstract void repair();
}
