package Qbit.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
public class Data5 {
    public static void main (String[] args) throws IOException {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(5);
        array.add(4);
        array.add(3);
        array.add(0);
        int a =  array.get(3);
        Collections.sort(array);
        System.out.println(array);
        System.out.println(array.size());


    }
}