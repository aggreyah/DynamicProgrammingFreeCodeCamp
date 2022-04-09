public class CountConstructTabulation {
    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "d"}));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
    }

    private static int countConstruct(String targetWord, String[] wordBank) {
        int[] table = new int[targetWord.length() + 1];
        table[0] = 1;

        for (int i = 0; i < targetWord.length() + 1; i++){
            String currentWord = targetWord.substring(i);
            if (table[i] != 0){
                for (String word: wordBank){
                    if (i + word.length() <= targetWord.length() && currentWord.startsWith(word)){
                        table[i + word.length()] += table[i];
                    }
                }
            }
        }
        return table[targetWord.length()];
    }
}
