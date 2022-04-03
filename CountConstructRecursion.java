public class CountConstructRecursion {
    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstruct("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee"}));
    }

    private static int countConstruct(String targetString, String[] wordBank) {
        if (targetString.isEmpty()) return 1;

        int numOfWays = 0;

        for (String word : wordBank) {
            if (targetString.startsWith(word)){
                String suffix = targetString.substring(word.length());
                int countWaysOfTheRest = countConstruct(suffix, wordBank);
                numOfWays += countWaysOfTheRest;
            }
        }
        return numOfWays;
    }
}
