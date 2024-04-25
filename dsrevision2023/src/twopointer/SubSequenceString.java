package twopointer;

public class SubSequenceString {

    public static boolean isSubsequence(String s, String t) {
        int linearIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (t.contains(Character.toString(s.charAt(i)))) {
                int currIndex = linearIndex + t.substring(linearIndex).indexOf(s.charAt(i));
                if (currIndex >= linearIndex) {
                    linearIndex = currIndex + 1;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("twn", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxn"));
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

}
