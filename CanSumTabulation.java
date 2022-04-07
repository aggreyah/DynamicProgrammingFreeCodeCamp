public class CanSumTabulation {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));
        System.out.println(canSum(300, new int[]{7, 14}));
    }

    private static boolean canSum(int targetSum, int[] ints) {
        boolean[] table = new boolean[targetSum + 1];
        for (int i = 0; i <= targetSum; i++){
            table[i] = false;
        }
        table[0] = true;

        for (int i = 0; i <= targetSum; i++){
            if (table[i] == true){
                for (int item: ints){
                    if (i + item <= targetSum)
                        table[i + item] = true;
                }
            }
        }
        return table[targetSum];
    }
}
