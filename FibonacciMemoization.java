import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {
    public static void main(String[] args) {
        System.out.println(fib(300, new HashMap<>()));
    }

    private static BigInteger fib(int n, Map<Integer, BigInteger> map) {
        if (map.containsKey(n))
            return map.get(n);
        else if (n <= 2)
            return BigInteger.ONE;
        else {
            map.put(n, fib(n - 1, map).add(fib(n - 2, map)));
        }
        return map.get(n);
    }
}
