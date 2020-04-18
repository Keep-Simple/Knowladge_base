package BaseCourse.OPP_Challange;

    class Hamburger {

    private int price;
    private String rollType;
    private String meat;


    public Hamburger(int price, String rollType, String meat) {
        this.price = price;
        this.rollType = rollType;
        this.meat = meat;
    }

    public void addCheese() {
        this.price += 5;
    }

    public void addTomatoes() {
        this.price += 3;
    }

    public void addCucumber() {
        this.price += 2;
    }

    public void addKetchup() {
        this.price += 1;
    }

    public int getPrice() {
        return price;
    }

}
