package Transport;

import java.util.Objects;

public class Car extends Transport implements Competing {

    private final BodyType typeBody;

    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хэтчбек"),
        COUPE("Купе"),
        WAGON("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Мультивэн");

        private String bodyType;

        BodyType(String bodyType) {
            this.bodyType = bodyType;
        }

        public String getBodyType() {
            return bodyType;
        }

        public void setBodyType(String bodyType) {
            this.bodyType = bodyType;
        }

        public static void checkBodyType(Car item) {
            String test = BodyType.valueOf(item.typeBody.name()).bodyType;
            if (test == null || test.length() == 0) {
                System.out.println("Данных недостаточно");
            } else {
                System.out.println("Легковой автомобиль " + item.getBrand() + " " + item.getModel() +
                        " имеет тип кузова: " + test);
            }
        }
    }

    public Car(String brand, String model, double engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.typeBody = bodyType;
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
        return "Транспорт. Легковой автомобиль. " +
                " Марка: " + brand +
                ". Модель: " + model +
                ". Объём двигателя: " + engineVolume + " л." +
                " Тип кузова: " + typeBody.getBodyType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return typeBody == car.typeBody;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeBody);
    }
}
