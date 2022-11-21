package Transport;

import java.util.Objects;

public class Bus extends Transport implements Competing {

    private final TypeOfCapacity typeOfCapacity;

    public enum TypeOfCapacity {

        VERY_SMALL("до 10 мест"),
        SMALL("до 25 мест"),
        AVERAGE("от 40 до 50 мест"),
        LARGE("от 60 до 80 мест"),
        VERY_LARGE("от 100 до 120 мест");

        private String typeOfCapacity1;

        TypeOfCapacity(String typeOfCapacity) {
            this.typeOfCapacity1 = typeOfCapacity;
        }

        public String getTypeOfCapacity() {
            return typeOfCapacity1;
        }

        public void setTypeOfCapacity(String typeOfCapacity) {
            this.typeOfCapacity1 = typeOfCapacity;
        }

        public static String checkTypeOfCapacity(Bus item) {
            String test = TypeOfCapacity.valueOf(item.typeOfCapacity.name()).typeOfCapacity1;
            if (test == null || test.length() == 0) {
                System.out.println("Данных недостаточно");
            } else {
                System.out.println("Автобус " + item.getBrand() + " " + item.getModel() +
                        " имеет вместимость салона: " + test);
            }
            return test;
        }
    }

    public Bus(String brand, String model, double engineVolume, TypeOfCapacity typeOfCapacity) {
        super(brand, model, engineVolume);
        this.typeOfCapacity = typeOfCapacity;
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
        return "Транспорт. Автобус. " +
                " Марка: " + brand +
                ". Модель: " + model +
                ". Объём двигателя: " + engineVolume + " л." +
                " Тип вместимости: " + typeOfCapacity.getTypeOfCapacity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return typeOfCapacity == bus.typeOfCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfCapacity);
    }
}
