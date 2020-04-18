package basics.BaseCourse.Inheritance;

class Car extends Vehicle {

    private String carName;
    private int maxGear;
    private int currentGear;

    public Car(String carName, int maxGear, int maxSpeed) {
        super(maxSpeed, "Car");
        this.carName = carName;
        this.maxGear = maxGear;
        this.currentGear = 0;
    }

    @Override
    protected void move() {
        super.move();
        System.out.printf("And your gear is : %d. ", currentGear);
    }

    protected void changeGear(int validateGear) {
        if (currentGear + validateGear <= 0 || currentGear + validateGear > maxGear)
            System.out.println("Oops, machine is gonna broke. Changes denied");
        else {
            currentGear += validateGear;
            System.out.printf("Changed successfully, current gear is : %d\n", currentGear);
        }
    }
}
