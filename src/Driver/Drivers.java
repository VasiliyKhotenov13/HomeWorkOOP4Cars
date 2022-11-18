package Driver;

import Transport.Transport;

public abstract class Drivers<T extends Transport> {

    private String fullName;
    private String driverLicence;
    private int experience;
    private final T car;

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

    @Override
    public String toString() {
        return "Водитель " + fullName +
                ", имеет водительское удостоверение категории " + driverLicence +
                ", стаж: " + experience + " лет, водит автомобиль " +
                this.car.getBrand() + ' ' + this.car.getModel() + " и будет участвовать в заезде!";
    }
}
