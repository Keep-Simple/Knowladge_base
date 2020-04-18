package playground;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathOlymp {

    static boolean isSquare(double num) {
        double a = Math.sqrt(num);
        return (a - Math.floor(a) == 0);
    }

    static void subsetSums (int []arr, int l, int r, int sum, List<Integer> ar ) {
        if (l > r) {
            ar.add(sum);
            return;
        }
        subsetSums(arr, l + 1, r, sum + arr[l], ar);
        subsetSums(arr, l + 1, r, sum, ar);
    }

    public static void main(String[] args) {
        List<Integer> ar = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[7];
        int i = 0;
        while (scanner.hasNextInt()) {
            array[i++] = scanner.nextInt();
            if(i==7) break;
        }
        boolean flag = true;
        subsetSums (array, 0, array.length - 1, 0, ar);
        for (int j : ar) {
            if (isSquare(j) && j !=0) {
                System.out.println(j);
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("Yep");
        else
            System.out.println("Nope");
    }
}