import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstructMemoization {
    public static void main(String[] args) {
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, new HashMap<>()));
        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}, new HashMap<>()));
        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar", "d"}, new HashMap<>()));
        System.out.println(allConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}, new HashMap<>()));
    }

    private static List<List<String>> allConstruct(String targetWord, String[] wordBank, Map<String, List<List<String>>> map) {
        if (map.containsKey(targetWord)) return map.get(targetWord);
        List<List<String>> emptyListOfLists = new ArrayList<>();
        emptyListOfLists.add(new ArrayList<>());
        if (targetWord == "") return emptyListOfLists;

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank){
            if (targetWord.startsWith(word)){
                String suffix = targetWord.substring(word.length());
                List<List<String>> allSuffix = allConstruct(suffix, wordBank, map);
                List<List<String>> allTarget = new ArrayList<>();
                allTarget.addAll(allSuffix);
                for (List<String> list : allTarget){
                    list.add(0, word);
                    result.add(list);
                }
            }
        }
        map.put(targetWord, result);
        return result;
    }
}
