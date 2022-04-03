import java.util.ArrayList;
import java.util.List;

public class HowSumRecursion {
    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3}));
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSum(7, new int[]{2, 4}));
        System.out.println(howSum(8, new int[]{2, 3, 5}));
        System.out.println(howSum(300, new int[]{7, 14}));
    }

    private static List<Integer> howSum(int targetSum, int[] ints) {
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int item : ints){
            List<Integer> remainderResult = howSum(targetSum - item, ints);
            if (remainderResult != null){
                List<Integer> result = new ArrayList<>(remainderResult);
                result.add(item);
                return result;
            }
        }
        return null;
    }
}
