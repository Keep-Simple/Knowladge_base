package basics.BaseCourse.Encapsulation;

    public class Printer {
        /**
         * Protecting data with private
         * Holding inner methods private(methods that won't be called)
         */
        private int tonerLvl;
        private int hasPrinted;
        private boolean isDuplex;

        public Printer(int tonerLvl, boolean isDuplex) {
            if (tonerLvl > -1 && tonerLvl < 101)
                this.tonerLvl = tonerLvl;
            else
                System.out.println("Wrong % filled");
            this.hasPrinted = 0;
            this.isDuplex = isDuplex;
        }

        public int fillPrinter(int fill) {
            this.tonerLvl += fill;
            if (this.tonerLvl > 100)
                return -1;
            if (this.tonerLvl < 0)
                return -1;
            System.out.printf("Printer is %d percents full", this.tonerLvl);
            return this.tonerLvl;
        }

        private int printPages(int numOfPages) {
            int temp = this.hasPrinted;
            if (numOfPages < 0)
                return -1;
            if (this.isDuplex) {
                this.hasPrinted += numOfPages / 2 + numOfPages % 2;
            } else {
                this.hasPrinted += numOfPages;
            }
            return this.hasPrinted - temp;
        }


        public static void main(String[] args) {
            Printer printer = new Printer(70,true);
            System.out.println(printer.printPages(9));
            printer.fillPrinter(25);
        }
    }
