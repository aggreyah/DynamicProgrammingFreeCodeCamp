import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSumMemoization {
    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3}, new HashMap<>()));
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        System.out.println(howSum(7, new int[]{2, 4}, new HashMap<>()));
        System.out.println(howSum(8, new int[]{2, 3, 5}, new HashMap<>()));
        System.out.println(howSum(5321, new int[]{7, 14}, new HashMap<>()));
    }

    private static List<Integer> howSum(int targetSum, int[] ints, Map<Integer, List<Integer>> map) {
        if (map.containsKey(targetSum)) return map.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int item : ints){
            List<Integer> remainderResult = howSum(targetSum - item, ints, map);
            if (remainderResult != null){
                List<Integer> result = new ArrayList<>(remainderResult);
                result.add(item);
                map.put(targetSum, result);
                return map.get(targetSum);
            }
        }
        map.put(targetSum, null);
        return null;
    }
}
