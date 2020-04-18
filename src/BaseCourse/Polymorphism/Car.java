package BaseCourse.Polymorphism;

class Car {

    private int numOfWheels;
    private boolean hasEngine;
    private String name;
    private int numOfCylinders;

    public Car(String name, int numOfCylinders) {
        this.name = name;
        this.numOfCylinders = numOfCylinders;
        this.numOfWheels = 4;
        this.hasEngine = true;
    }

    public int getNumOfWheels() {
        return numOfWheels;
    }

    public boolean isHasEngine() {
        return hasEngine;
    }

    public String getName() {
        return name;
    }

    public int getNumOfCylinders() {
        return numOfCylinders;
    }

    public void startEngine() {
        System.out.println("Engine started");
    }

    public void brake() {
        System.out.println("Braking");
    }

    public void accelerate() {
        System.out.println("Accelerating");
    }
}

class LandRover extends Car {

    public LandRover(String name, int numOfCylinders) {
        super(name, numOfCylinders);
    }

    @Override
    public void startEngine() {
        System.out.println("LandRover engine has started");
    }

    @Override
    public void brake() {
        System.out.println("LandRover is braking");
    }

    @Override
    public void accelerate() {
        System.out.println("LandRover is accelerating");
    }

}


class Volvo extends Car {

    public Volvo(int numOfCylinders, String name) {
        super(name, numOfCylinders);
    }

    @Override
    public void startEngine() {
        System.out.println("Volvo engine has started");
    }

    @Override
    public void brake() {
        System.out.println("Volvo is braking");
    }

    @Override
    public void accelerate() {
        System.out.println("Volvo is accelerating");
    }
}

class Main {
    public static void main(String[] gay) {
        Car hui = new Volvo(4, "vaginka");
        hui.accelerate();
        Car clen = new LandRover("clen", 7);
        System.out.println(clen.getNumOfCylinders());
        System.out.println(clen.isHasEngine());
        System.out.println(clen.getName());
        System.out.println();
    }
}








