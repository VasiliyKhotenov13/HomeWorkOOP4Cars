import Driver.DriverB;
import Driver.DriverC;
import Driver.DriverD;
import Transport.Bus;
import Transport.Car;
import Transport.Transport;
import Transport.Truck;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Ламборджини", "Галлардо", 5.4, Car.BodyType.COUPE);
        Car car2 = new Car("Порш", "Панамера", 4.5, Car.BodyType.SEDAN);
        Car car3 = new Car("Тойота", "Камри", 3.5, Car.BodyType.SEDAN);
        Car car4 = new Car("Лада", "Веста Спорт", 1.6, Car.BodyType.CROSSOVER);

        Bus bus1 = new Bus("Икарус", "265", 8.0, Bus.TypeOfCapacity.VERY_LARGE);
        Bus bus2 = new Bus("Икарус", "256", 7.2, Bus.TypeOfCapacity.AVERAGE);
        Bus bus3 = new Bus("ГАЗель", "CITY", 3.0, Bus.TypeOfCapacity.SMALL);
        Bus bus4 = new Bus("KIA", "GrandBird", 12.3, Bus.TypeOfCapacity.LARGE);

        Truck truck1 = new Truck("Scania", "R 730", 16.4, Truck.LoadCapacity.N1);
        Truck truck2 = new Truck("MAN", "TGX", 15.2, Truck.LoadCapacity.N2);
        Truck truck3 = new Truck("Mercedes-Benz", "Actros SLT", 15.6, Truck.LoadCapacity.N3);
        Truck truck4 = new Truck("КамАЗ", "4326-9", 18.5, Truck.LoadCapacity.N1);

        System.out.println(car1.toString());
        System.out.println(bus2.toString());
        System.out.println(truck4.toString());

        System.out.println("----------------------------------------------------------------------------------");

        DriverB driverB1 = new DriverB("Иван Иваныч", "B", 15, car3);
        DriverB driverB2 = new DriverB("Виктор Семёныч", "B", 12, car1);
        DriverC driverC1 = new DriverC("Игорь Ракетович", "С", 30, bus4);
        DriverC driverC2 = new DriverC("Олег Торпедович", "С", 33, bus2);
        DriverD driverD1 = new DriverD("Серёга", "D", 9, truck3);
        DriverD driverD2 = new DriverD("Санёк", "D", 25, truck4);

        System.out.println(driverB1);
        System.out.println(driverB2);
        System.out.println(driverC1);
        System.out.println(driverC2);
        System.out.println(driverD1);
        System.out.println(driverD2);

        System.out.println("----------------------------------------------------------------------------------");

        driverD2.startMovement();
        driverC1.stopMovement();
        driverB2.refuel();

        System.out.println("----------------------------------------------------------------------------------");

        Car.BodyType.checkBodyType(car3);
        Bus.TypeOfCapacity.checkTypeOfCapacity(bus2);
        Truck.LoadCapacity.checkLoadCapacity(truck1);
    }
}