package Driver;

import Transport.Transport;

import java.util.Objects;

public abstract class Drivers<T extends Transport> {

    private String fullName;
    private String driverLicence;
    private int experience;
    private T car;

    public Drivers(String fullName, String driverLicence, int experience, T car) {
        this.fullName = fullName;
        this.driverLicence = driverLicence;
        this.experience = experience;
        this.car = car;
    }

    public void startMovement() {
        System.out.println("На старт! Внимание! Погнали! " + this.fullName + " начал движение!");
    }

    public void stopMovement() {
        System.out.println(this.fullName + " финишировал!");
    }

    public void refuel() {
        System.out.println("Водитель " + this.fullName + " заправляет "
                + this.car.getBrand() + " " + this.car.getModel());
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDriverLicence() {
        return driverLicence;
    }

    public void setDriverLicence(String driverLicence) {
        this.driverLicence = driverLicence;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public T getCar() {
        return car;
    }

    public void setCar(T car) {
        if (car == null) {
            throw new IllegalArgumentException("Необходимо указать категорию прав!");
        }
        this.car = car;
    }

    public void add(Drivers<?> driver) {
    }

    @Override
    public String toString() {
        return "Водитель " + fullName +
                ", имеет водительское удостоверение категории " + driverLicence +
                ", стаж: " + experience + " лет, водит автомобиль " +
                this.car.getBrand() + ' ' + this.car.getModel() + " и будет участвовать в заезде!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drivers<?> drivers = (Drivers<?>) o;
        return experience == drivers.experience && Objects.equals(fullName, drivers.fullName) && Objects.equals(driverLicence, drivers.driverLicence) && Objects.equals(car, drivers.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, driverLicence, experience, car);
    }
}
