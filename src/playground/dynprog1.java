package playground;

import java.util.HashMap;
import java.util.Map;

//using recursion with caching elements
public class dynprog1 {
    private static int f(int n) {
        if (n == 0 || n == 1) return 1;
        if (n % 2 == 0) {
            return fcashe(n / 2) + fcashe(n / 2 - 1);
        } else {
            return fcashe((n - 1) / 2) - fcashe((n - 1) / 2 - 1);
        }
    }

    private static Map<Integer, Integer> cache = new HashMap<>();

    private static int fcashe(int n) {
        if (!cache.containsKey(n)) {
            cache.put(n, f(n));
        }
        return cache.get(n);
    }

    public static void main(String args[]) {
        System.out.println(f(237));
    }
}
