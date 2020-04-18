package Qbit.Shifr;
import java.io.*;
public class Shifr2 {
    public static void main (String[] args)  throws IOException{
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int count = 0;
        boolean flag;
        String[] values = reader.readLine().trim().split("\\s+");
        for(String i : values){
            flag = true;
            for(int j = 0; j < i.length()/2; j++){
                if(!(i.charAt(j) == i.charAt(i.length() - 1 - j))){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        pw.print(count);
        pw.close();

    }
}