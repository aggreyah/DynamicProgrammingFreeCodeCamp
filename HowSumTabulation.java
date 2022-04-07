import java.util.ArrayList;
import java.util.List;

public class HowSumTabulation {
    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3}));
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSum(7, new int[]{2, 4}));
        System.out.println(howSum(8, new int[]{2, 3, 5}));
        System.out.println(howSum(300, new int[]{7, 14}));
    }

    private static List<Integer> howSum(int targetSum, int[] ints) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i <= targetSum; i++){
            table.add(null);
        }
        table.set(0, new ArrayList<>());

        for (int i = 0; i <= targetSum; i++){
            if (table.get(i) != null){
                for (int num : ints){
                    if (i + num <= targetSum){
                            table.set(i + num, new ArrayList<>(table.get(i)));
                            table.get(i + num).add(num);
                    }
                }
            }
        }
        return table.get(targetSum);
    }
}
