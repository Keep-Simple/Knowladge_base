package basics.BaseCourse.InterfaceChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ISaveAble firstPlayer = new Player(90, 50, "Fighter");
        ISaveAble firstMonster = new Monster("Creep", 76, 228);
        saveObject(firstMonster);
        saveObject(firstPlayer);
        System.out.println(firstMonster);
        System.out.println(firstPlayer);
        loadObject(firstMonster);
        System.out.println(firstMonster);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        boolean quit = false;
        System.out.println("Chose\n" +
                "1 - to enter a string\n" +
                "0 - to quit");
        while (!quit) {
            System.out.println("Choose an option : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string :");
                    String str = scanner.nextLine();
                    values.add(index++, str);
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
        return values;
    }

    public static void saveObject(ISaveAble objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i));
        }
        System.out.println("=========================");
    }

    public static void loadObject(ISaveAble objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }


}
