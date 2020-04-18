package Qbit.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Data3 {
    public static void main (String[] args) throws IOException {
        List<Integer> array = new ArrayList<>();
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            array.add(sc.nextInt());
        }
        int del = sc.nextInt();
        array.removeIf(Predicate.isEqual(del));
        sc.close();
        int i = 0;
        for(int element : array){
            pw.print(array.get(i) + " ");
            i++;
        }
        pw.close();
    }
}