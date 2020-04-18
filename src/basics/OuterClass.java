package basics;

public class OuterClass {
    final int outerVariable = 10000;
    static int staticOuterVariable = 2000;

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        System.out.println(outer.run());
    }

    Object run() {
        int localVariable = 666;
        final int finalLocalVariable = 300;

        class LocalClass {
            int innerVariable = 40;
            int getSum(int parameter) {
                // Cannot access localVariable here
                return outerVariable + staticOuterVariable +
                        finalLocalVariable + innerVariable + parameter;
            }
        }
        LocalClass local = new LocalClass();
        System.out.println(local.getSum(5));
        return local;
    }
}