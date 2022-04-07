import java.math.BigInteger;

public class FibonacciTabulation {
    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fib(15));
        System.out.println(fib(250));
    }

    private static BigInteger fib(int n) {
        BigInteger[] table = new BigInteger[n + 1];
        for (int i = 0; i <= n; i++)
            table[i] = BigInteger.ZERO;
        table[1] = BigInteger.ONE;

        for (int i = 0; i <= n; i++){
            table[i + 1] = table[i + 1].add(table[i]);
            try {
                table[i + 2] = table[i + 2].add(table[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }

        }
        return table[n];
    }
}
