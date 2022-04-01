public class CanSumRecursion {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));
        System.out.println(canSum(300, new int[]{7, 14}));
    }

    private static boolean canSum(int targetSum, int[] ints) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int item: ints){
            if (canSum(targetSum - item, ints)) return true;
        }
        return false;
    }
}
