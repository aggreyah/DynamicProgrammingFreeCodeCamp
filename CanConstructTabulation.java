public class CanConstructTabulation {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
    }

    private static boolean canConstruct(String targetWord, String[] wordBank) {
        boolean[] table = new boolean[targetWord.length() + 1];

        table[0] = true;

        for (int i = 0; i < targetWord.length(); i++){
            String currentTarget = targetWord.substring(i);
            if (table[i] == true){
                for (String word: wordBank){
                    if (currentTarget.startsWith(word) && i + word.length() <= targetWord.length()){
                        table[i + word.length()] = true;
                    }
                }
            }
        }
        return table[targetWord.length()];
    }
}
