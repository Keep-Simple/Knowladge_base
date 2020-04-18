package Qbit.Shifr;
import java.io.*;
import java.util.Scanner;
public class Shifr8 {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int [][] array = new int[b][a];

        for(int i = 0; i < a; i++)
            array[0][i] = 1;
        for(int i = 0; i < b; i++)
            array[i][0] = 1;
        for(int i = 0; i < b; i++)
            array[i][a-1] = 1;
        for(int i = 0; i < b-2; i++)
            array[i][a/2] = 1;

        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                System.out.print(array[j][i]);
            }
            System.out.print("\n");
        }

    }
}