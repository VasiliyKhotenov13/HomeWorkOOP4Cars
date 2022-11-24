import Driver.DriverB;
import Driver.DriverC;
import Driver.DriverD;
import Driver.Drivers;
import Transport.Bus;
import Transport.Car;
import Transport.Transport;
import Transport.Truck;
import Transport.Sponsor;
import Transport.Mechanic;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Mechanic<Car> igor = new Mechanic<Car>("Игорь", "Петрович", "Гайка");
        Mechanic<Bus> vitya = new Mechanic<Bus>("Витя", "Простой парень", "Мотор");
        Mechanic<Truck> semen = new Mechanic<Truck>("Семён", "Семёныч", "Авто Слон!");

        Sponsor lukoil = new Sponsor("Лукойл", 5_000_000);
        Sponsor beerCompany = new Sponsor("КрымПиво", 9_000_000);

        Car car1 = new Car("Ламборджини", "Галлардо", 5.4, Car.BodyType.COUPE);
        Car car2 = new Car("Порш", "Панамера", 4.5, Car.BodyType.SEDAN);
        car2.addDriver(new DriverB("Виктор Палыч", "В", 12, car2));
        car2.addMechanic(igor);
        car2.addSponsor(lukoil);
        Car car3 = new Car("Тойота", "Камри", 3.5, Car.BodyType.SEDAN);
        Car car4 = new Car("Лада", "Веста Спорт", 1.6, Car.BodyType.CROSSOVER);

        Bus bus1 = new Bus("Икарус", "265", 8.0, Bus.TypeOfCapacity.VERY_LARGE);
        Bus bus2 = new Bus("Икарус", "256", 7.2, Bus.TypeOfCapacity.AVERAGE);
        Bus bus3 = new Bus("ГАЗель", "CITY", 3.0, Bus.TypeOfCapacity.SMALL);
        Bus bus4 = new Bus("KIA", "GrandBird", 12.3, Bus.TypeOfCapacity.LARGE);
        bus4.addMechanic(vitya);
        bus4.addSponsor(beerCompany);



        Truck truck1 = new Truck("Scania", "R 730", 16.4, Truck.LoadCapacity.N1);
        truck1.addMechanic(semen);
        truck1.addSponsor(beerCompany);
        Truck truck2 = new Truck("MAN", "TGX", 15.2, Truck.LoadCapacity.N2);
        Truck truck3 = new Truck("Mercedes-Benz", "Actros SLT", 15.6, Truck.LoadCapacity.N3);
        Truck truck4 = new Truck("КамАЗ", "4326-9", 18.5, Truck.LoadCapacity.N1);

        System.out.println(car1.toString());
        System.out.println(bus2.toString());
        System.out.println(truck4.toString());

        System.out.println("----------------------------------------------------------------------------------");

        DriverB driverB1 = new DriverB("Иван Иваныч", "B", 15, car3);
        DriverB driverB2 = new DriverB("Виктор Семёныч", "B", 12, car2);
        DriverC driverC1 = new DriverC("Игорь Ракетович", "С", 30, bus4);
        DriverC driverC2 = new DriverC("Олег Торпедович", "С", 33, bus2);
        DriverD driverD1 = new DriverD("Серёга", "D", 9, truck1);
        DriverD driverD2 = new DriverD("Санёк", "D", 25, truck4);

        bus4.addDriver(driverC2);
        truck1.addDriver(driverD2);
        car2.addDriver(driverB2);

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

        System.out.println("----------------------------------------------------------------------------------");

        service(car1, car2, car3, car4,
                bus1, bus2, bus3, bus4,
                truck1, truck2, truck3, truck4);

        car2.addDriver(new DriverB("Vitya", "B", 12, car2));

        List<Transport> transports = List.of(
                car2,
//                car2, car3, car4,
                bus4,
//                bus2, bus3, bus4,
                truck1);
//                truck2, truck3, truck4);

        for (Transport transport :
                transports) {
            printInfo(transport);
        }

    }

    public static void printInfo(Transport transport) {
        System.out.println("Инофрмация по автомобилю " + transport.getBrand() + " "
                + transport.getModel());
        System.out.println("Водители: " + transport.getDrivers());
        System.out.println("Спонсоры: " + transport.getSponsors());
        System.out.println("Механики: " + transport.getMechanics());

        System.out.println();

    }

    private static void service(Transport... transports) {
        for (Transport transport : transports) {
            if (!transport.service()) {
                try {
                    throw new RuntimeException("Автомобиль " + transport.getBrand() + " " +
                            transport.getModel() + " не прошел диагностику!");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}