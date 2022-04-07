import java.math.BigInteger;

public class GridTravellerTabulation {
    public static void main(String[] args) {
        System.out.println(gridTraveller(1, 1));
        System.out.println(gridTraveller(2, 3));
        System.out.println(gridTraveller(3, 2));
        System.out.println(gridTraveller(3, 3));
        System.out.println(gridTraveller(58, 58));
    }

    private static BigInteger gridTraveller(int m, int n) {
        BigInteger[][] table = new BigInteger[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                table[i][j] = BigInteger.ZERO;
            }
        }
        table[1][1] = BigInteger.ONE;

        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
                BigInteger current = table[i][j];
                if (i + 1 <= m)
                    table[i + 1][j] = table[i + 1][j].add(current);
                if (j + 1 <= n)
                    table[i][j + 1] = table[i][j + 1].add(current);

            }
        }
        return table[m][n];
    }
}
