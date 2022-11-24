package Transport;

import java.util.Objects;

public class Truck extends Transport implements Competing {

    private final LoadCapacity capacity;

    public enum LoadCapacity {

        N1("c полной массой до 3,5 тонн"),
        N2("с полной массой свыше 3,5 до 12 тонн"),
        N3("с полной массой свыше 12 тонн");

        private String loadCapacity;

        LoadCapacity(String loadCapacity) {
            this.loadCapacity = loadCapacity;
        }

        public String getLoadCapacity() {
            return loadCapacity;
        }

        public void setLoadCapacity(String loadCapacity) {
            this.loadCapacity = loadCapacity;
        }

        public static void checkLoadCapacity(Truck item) {
            String test = LoadCapacity.valueOf(item.capacity.name()).loadCapacity;
            if (test == null || test.length() == 0) {
                System.out.println("Данных недостаточно");
            } else {
                System.out.println("Грузовик " + item.getBrand() + " " + item.getModel() +
                        " имеет грузоподъемность: " + test);
            }
        }
    }

    public Truck(String brand, String model, double engineVolume, LoadCapacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
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
    public boolean service() {
        return Math.random() > 0.75;
    }

    @Override
    public void repair() {
        System.out.println("Грузовик " + getBrand() + " " + getModel() + " отремонтирован!!!");
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


    @Override
    public String toString() {
        return "Транспорт. Грузовой автомобиль. " +
                " Марка: " + brand +
                ". Модель: " + model +
                ". Объём двигателя: " + engineVolume + " л." +
                " Тип грузоподъемности: " + capacity.getLoadCapacity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return capacity == truck.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }
}
