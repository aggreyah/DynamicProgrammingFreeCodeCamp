public class GridTravellerRecursion {
    public static void main(String[] args) {
        System.out.println(gridTraveller(3, 3));
    }

    private static long gridTraveller(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        else if (m == 1 && n == 1)
            return 1;
        else {
            return gridTraveller(m - 1, n) + gridTraveller(m, n - 1);
        }
    }
}
