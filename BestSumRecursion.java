import java.util.ArrayList;
import java.util.List;

public class BestSumRecursion {
    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(bestSum(8, new int[]{2, 3, 5}));
        System.out.println(bestSum(8, new int[]{1, 4, 5}));
//        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}));
    }

    private static List<Integer> bestSum(int targetSum, int[] ints) {
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestCombination = null;
        for (int item : ints){
            List<Integer> remainderCombination = bestSum(targetSum - item, ints);
            if (remainderCombination != null){
                List<Integer> result = new ArrayList<>(remainderCombination);
                result.add(item);
                if (shortestCombination == null || shortestCombination.size() > result.size())
                    shortestCombination = result;
            }
        }
        return shortestCombination;
    }
}
