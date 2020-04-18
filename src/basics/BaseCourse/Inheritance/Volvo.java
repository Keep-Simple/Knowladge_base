package basics.BaseCourse.Inheritance;

    class Volvo extends Car {

        private String model;

        public Volvo(String model) {
            super("Volvo", 6, 200);
            this.model = model;
        }

        @Override
        protected void move() {
            super.move();
            System.out.println("Btw, you are driving : " + model + "!" );
        }

        public static void main(String[] args) {
            Car firstCar = new Volvo("xc90");
            firstCar.changeSpeed(190);
            firstCar.changeGear(5);
            firstCar.move();
            firstCar.changeGear(3);
            firstCar.changeSpeed(-200);
            firstCar.Steering();

        }
    }