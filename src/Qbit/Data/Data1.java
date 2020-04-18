package Qbit.Data;
import java.io.*;
import java.util.Scanner;
public class Data1 {
    public static void main (String[] args) throws IOException {
            Scanner sc = new Scanner(new File("input.txt"));
            PrintWriter pw = new PrintWriter(new File("output.txt"));
            int n = sc.nextInt(); int temp= sc.nextInt();
            int count = 0;
            while(sc.hasNextInt()){
                int a = sc.nextInt();
                if (a > temp){
                    count++;
                    temp = a;
                }
            }
            sc.close();
            pw.print(count);
            pw.close();
    }
}