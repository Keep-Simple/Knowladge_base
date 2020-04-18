package Qbit.Shifr;
import java.io.*;
import java.util.Scanner;
public class Shifr6 {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char [][] array = new char[13][4];

        for(int j = 0; j < 4; j++) {
            for(int i = 0; i < 13; i++) {
                array[i][j] = '*';
            }
        }

        char a;
        while (sc.hasNext()) {
            switch (sc.nextInt()) {
                case 0:
                    a = sc.next().charAt(0);
                    array[6][0] = a;
                    break;
                case 1:
                    a = sc.next().charAt(0);
                    array[4][1] = a;
                    break;
                case 2:
                    a = sc.next().charAt(0);
                    array[8][1] = a;
                    break;
                case 3:
                    a = sc.next().charAt(0);
                    array[1][2] = a;
                    break;
                case 4:
                    a = sc.next().charAt(0);
                    array[5][2] = a;
                    break;
                case 5:
                    a = sc.next().charAt(0);
                    array[7][2] = a;
                    break;
                case 6:
                    a = sc.next().charAt(0);
                    array[11][2] = a;
                    break;
                case 7:
                    a = sc.next().charAt(0);
                    array[3][3] = a;
                    break;
                case 8:
                    a = sc.next().charAt(0);
                    array[6][3] = a;
                    break;
                case 9:
                    a = sc.next().charAt(0);
                    array[9][3] = a;
                    break;
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; j++) {
                System.out.print(array[j][i]);
            }
            System.out.print("\n");
        }

    }
}