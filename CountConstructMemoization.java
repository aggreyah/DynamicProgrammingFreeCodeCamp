import java.util.HashMap;
import java.util.Map;

public class CountConstructMemoization {
    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, new HashMap<>()));
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));
    }

    private static int countConstruct(String targetString, String[] wordBank, Map<String, Integer> map) {
        if (map.containsKey(targetString)) return map.get(targetString);
        if (targetString.isEmpty()) return 1;

        int numOfWays = 0;

        for (String word : wordBank) {
            if (targetString.startsWith(word)){
                String suffix = targetString.substring(word.length());
                int countWaysOfTheRest = countConstruct(suffix, wordBank, map);
                numOfWays += countWaysOfTheRest;
            }
        }
        map.put(targetString, numOfWays);
        return numOfWays;
    }
}
