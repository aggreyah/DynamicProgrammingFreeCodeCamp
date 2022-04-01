import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class GridTravellerMemoization {
    public static void main(String[] args) {
        System.out.println(gridTraveller(55, 55, new HashMap<>()));
    }

    private static BigInteger gridTraveller(int m, int n, Map<String, BigInteger> map) {
        if (m == 0 || n == 0)
            return BigInteger.ZERO;
        else if (m == 1 && n == 1)
            return BigInteger.ONE;

        String key = m + "," + n;
        String keyReversed = reverse(key);

        if (map.containsKey(key) || map.containsKey(keyReversed)){
            return map.get(key) != null ? map.get(key) : map.get(keyReversed);
        }
        map.put(key, gridTraveller(m - 1, n, map).add(gridTraveller(m, n - 1, map)));
        return map.get(key);
    }

    private static String reverse(String key) {
        String result = "";
        for (char c: key.toCharArray())
            result = c + result;
        return result;
    }
}
