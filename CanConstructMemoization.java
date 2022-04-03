import java.util.HashMap;
import java.util.Map;

public class CanConstructMemoization {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));
    }

    private static boolean canConstruct(String targetWord, String[] wordBank, Map<String, Boolean> map) {
        if (map.containsKey(targetWord)) return map.get(targetWord);
        if (targetWord.isEmpty()) return true;

        for (String word: wordBank){
            if (targetWord.startsWith(word)){
                String suffix = targetWord.substring(word.length());
                if (canConstruct(suffix, wordBank, map)){
                    map.put(targetWord, true);
                    return true;
                }
            }
        }
        map.put(targetWord, false);
        return false;
    }
}
