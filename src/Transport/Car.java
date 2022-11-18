package Transport;

public class Car extends Transport implements Competing {

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startMoving() {
        System.out.println(getBrand() + " начал движение!");
    }

    @Override
    public void stopMoving() {
        System.out.println(getBrand() + " закончил движение!");
    }

    @Override
    public String toString() {
        return "Транспорт. Легковой автомобиль. " +
                " Марка: " + brand +
                ". Модель: " + model +
                ". Объём двигателя: " + engineVolume + " л.";
    }

    @Override
    public void pitStop() {
        System.out.println(getBrand() + " встал на пит-стоп!");
    }

    @Override
    public int bestLapTime() {
        return 0;
    }

    @Override
    public int maxSpeed() {
        return 0;
    }
}
