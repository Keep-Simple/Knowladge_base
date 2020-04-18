package Qbit.Olymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ol1 {

    private static Scanner scanner;
    static {
        try {
            scanner = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    String std1 = scanner.nextLine();
    String std2 = scanner.nextLine();

}
}
