import java.util.ArrayList;
import java.util.List;

public class AllConstructTabulation {
    public static void main(String[] args) {
        System.out.println(allConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        System.out.println(allConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}));
        System.out.println(allConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(allConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(allConstruct("aaaaaaaz",
                new String[]{"a", "aa", "aaa", "aaaa", "aaaaa"}));
    }

    private static List<List<String>> allConstruct(String targetWord, String[] wordBank) {
        List<List<List<String>>> table = new ArrayList<>();
        for (int i = 0; i <= targetWord.length(); i++){
            table.add(new ArrayList<>());
        }
        table.get(0).add(new ArrayList<>());

        for (int i = 0; i <= targetWord.length(); i ++){
            String currentTarget = targetWord.substring(i);
            if (!table.get(i).isEmpty())
                for (String word: wordBank){
                    if (currentTarget.startsWith(word) && i + word.length() <= targetWord.length()){
                        List<List<String>> previous = new ArrayList<>();
                        for (List<String> item: table.get(i)){
                            List<String> itemCopy = new ArrayList<>(item);
                            itemCopy.add(word);
                            previous.add(itemCopy);
                        }
                        table.get(i + word.length()).addAll(previous);
                    }
                }
        }
        return table.get(targetWord.length());
    }
}
