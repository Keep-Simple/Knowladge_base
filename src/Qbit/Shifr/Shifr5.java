package Qbit.Shifr;
import java.io.*;
public class Shifr5 {
    private static boolean check(int indx, char[] chars){
        if(indx != 0) {
            for (int i = indx; i < chars.length; i++) {
                if (!(chars[(i % indx)] == chars[i]))
                    return false;
            }
        }
        else{
            for(char i : chars)
                if(i != chars[indx])
                    return false;
        }
        return true;
    }

    public static void main (String[] args)  throws IOException{
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        char[] chars = reader.readLine().toCharArray();
        char MAIN = chars[0];
        int count = 0;

        for(char i : chars) {
            if(i==MAIN) {
                if(check(count,chars)) {
                    pw.print(count > 0 ? count : 1);
                    pw.close();
                    break;
                }
            }
            count++;
        }
            pw.print(chars.length);
            pw.close();
        }
    }
