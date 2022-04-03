import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSumMemoization {
    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        System.out.println(bestSum(8, new int[]{2, 3, 5}, new HashMap<>()));
        System.out.println(bestSum(8, new int[]{1, 4, 5}, new HashMap<>()));
        System.out.println(bestSum(100, new int[]{1, 2, 5, 25}, new HashMap<>()));
    }

    private static List<Integer> bestSum(int targetSum, int[] ints, Map<Integer, List<Integer>> map) {
        if (map.containsKey(targetSum)) return map.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestCombination = null;
        for (int item : ints){
            List<Integer> remainderCombination = bestSum(targetSum - item, ints, map);
            if (remainderCombination != null){
                List<Integer> resultCombination = new ArrayList<>(remainderCombination);
                resultCombination.add(item);
                if (shortestCombination == null || shortestCombination.size() > resultCombination.size())
                    shortestCombination = resultCombination;
            }
        }
        map.put(targetSum, shortestCombination);
        return shortestCombination;
    }

}
