public class FibonacciRecursion {
    public static void main(String[] args) {
        System.out.println(fib(50));
    }

    private static long fib(int n) {
        if (n <= 2)
            return 1;
        else{
            return fib(n - 1) + fib(n - 2);
        }
    }
}
