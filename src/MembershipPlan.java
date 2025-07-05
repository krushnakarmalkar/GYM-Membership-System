public class MembershipPlan {
    private int id;
    private String name;
    private int durationMonths;
    private double price;


    public MembershipPlan(String name, int durationMonths, double price) {
        this.name = name;
        this.durationMonths = durationMonths;
        this.price = price;
    }


    public MembershipPlan(int id, String name, int durationMonths, double price) {
        this.id = id;
        this.name = name;
        this.durationMonths = durationMonths;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
