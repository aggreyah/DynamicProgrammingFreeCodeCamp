public class FibonnacciRecursion {
    public static void main(String[] args) {
        System.out.println(fib(11));
    }

    private static int fib(int n) {
        if (n <= 2)
            return 1;
        else{
            return fib(n - 1) + fib(n - 2);
        }
    }
}
