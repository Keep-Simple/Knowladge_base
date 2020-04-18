package Qbit.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Data2 {
    public static void main (String[] args) throws IOException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            array.add(sc.nextInt());
        }
        array.remove(sc.nextInt()-1);
        sc.close();
        int i = 0;
        for(int element : array){
            pw.print(array.get(i) + " ");
            i++;
        }
        pw.close();
    }
}