public class CanConstructRecursion {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
    }

    private static boolean canConstruct(String targetWord, String[] wordBank) {
        if (targetWord.isEmpty()) return true;

        for (String word: wordBank){
            if (targetWord.startsWith(word)){
                String suffix = targetWord.substring(word.length());
                if (canConstruct(suffix, wordBank))
                    return true;
            }
        }
        return false;
    }
}
