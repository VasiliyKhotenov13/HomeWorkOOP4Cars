package Transport;

public class Sponsor {

    private final String name;
    private final int amount;

    public Sponsor(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void toSponsor() {
        System.out.println("Спонсор " + name + " проспонсировал заезд на " + amount + "$");
    }

    @Override
    public String toString() {
        return name + " сумма поддержки: " + amount;
    }
}
