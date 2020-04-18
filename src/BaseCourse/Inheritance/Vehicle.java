package BaseCourse.Inheritance;

class Vehicle {

    private int currentSpeed;
    private int maxSpeed;
    private String vehicleType;

    public Vehicle(int maxSpeed, String vehicleType) {
        this.maxSpeed = maxSpeed;
        this.vehicleType = vehicleType;
        this.currentSpeed = 0;
    }

    protected void Steering() {
        System.out.print("Nice job, cuz. You are driving a " + vehicleType);
    }

    protected void move() {
        System.out.printf("You are moving at the speed of : %d. ", currentSpeed);
    }

    protected void changeSpeed(int validateSpeed) {
        if (currentSpeed + validateSpeed <= 0 || currentSpeed + validateSpeed > maxSpeed)
            System.out.println("Oops, machine is gonna broke. Changes denied");
        else {
            currentSpeed += validateSpeed;
            System.out.printf("Changed successfully, current speed is : %d\n", currentSpeed);
        }
    }
}
