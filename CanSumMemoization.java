import java.util.HashMap;
import java.util.Map;

public class CanSumMemoization {
    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}, new HashMap<>()));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}, new HashMap<>()));
        System.out.println(canSum(7, new int[]{2, 4}, new HashMap<>()));
        System.out.println(canSum(8, new int[]{2, 3, 5}, new HashMap<>()));
        System.out.println(canSum(35346, new int[]{7, 14}, new HashMap<>()));
    }

    private static boolean canSum(int targetSum, int[] ints, Map<Integer, Boolean> map) {
        if (map.containsKey(targetSum)) return map.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int item: ints){
            if (canSum(targetSum - item, ints, map)){
                map.put(targetSum, true);
                return true;
            }
        }
        map.put(targetSum, false);
        return false;
    }
}
