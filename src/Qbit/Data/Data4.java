package Qbit.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Data4 {
    public static void main (String[] args) throws IOException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            array.add(sc.nextInt());
        }
        int idx = sc.nextInt();
        int var = array.get(idx-1);
        array.remove(idx-1);
        array.add(0,var);
        sc.close();
        int i = 0;
        for(int element : array){
            pw.print(array.get(i) + " ");
            i++;
        }
        pw.close();
    }
}