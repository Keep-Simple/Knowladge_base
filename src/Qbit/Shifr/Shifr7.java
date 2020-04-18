package Qbit.Shifr;
import java.io.*;
public class Shifr7 {
    private static int numSum(char[] num) {
        int sum = 0;
        for(char i : num){
            sum += Character.getNumericValue(i);
            sum %= 9;
        }
        return sum;
    }

    public static void main (String[] args)  throws IOException{
       // PrintWriter pw = new PrintWriter(new File("output.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         char[] str1 = reader.readLine().toCharArray();
         char[] str2 = reader.readLine().toCharArray();
         char[] str3 = reader.readLine().toCharArray();
         String str4 = reader.readLine();
         reader.close();

         if(str4.charAt(0) == '+'){
            if((numSum(str1) + numSum(str2)) % 9 == numSum(str3))
                System.out.println("perhaps");
            else
                System.out.println("impossible");
         }
         if(str4.charAt(0) == '-'){
             if(((((numSum(str1) - numSum(str2)) % 9) < 0) ? numSum(str1) - numSum(str2) + 9 : numSum(str1) - numSum(str2)) == numSum(str3))
                 System.out.println("perhaps");
             else
                 System.out.println("impossible");
         }
        if(str4.charAt(0) == '*'){
            if((numSum(str1) * numSum(str2)) % 9 == numSum(str3))
                System.out.println("perhaps");
            else
                System.out.println("impossible");
        }
    }
}