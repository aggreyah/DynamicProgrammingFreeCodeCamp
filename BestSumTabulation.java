import java.util.ArrayList;
import java.util.List;

public class BestSumTabulation {
    public static void main(String[] args) {
        System.out.println(bestSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(bestSum(8, new int[]{2, 3, 5}));
        System.out.println(bestSum(8, new int[]{1, 4, 5}));
        System.out.println(bestSum(100, new int[]{25, 1, 2, 5}));
    }

    private static List<Integer> bestSum(int targetSum, int[] ints) {
        List<List<Integer>> table = new ArrayList<>();

        for (int i = 0; i <= targetSum; i++){
            table.add(null);
        }

        table.set(0, new ArrayList<>());

        for (int i = 0; i <= targetSum; i++){
            if (table.get(i) != null){
                for (int num: ints){
                    if (i + num <= targetSum){
                        List<Integer> current = new ArrayList<>(table.get(i));
                        current.add(num);
                        if (table.get(i + num) == null || table.get(i + num).size() > current.size()){
                            table.set(i + num, new ArrayList<>(current));
                        }
                    }
                }
            }
        }
        return table.get(targetSum);
    }
}
