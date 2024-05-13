package strings;

public class LongestSubstringWORepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int j=0;j<s.length();j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = j; i < s.length(); i++) {
                if (sb.toString().indexOf(s.charAt(i)) < 0) {
                    sb.append(s.charAt(i));
                    if (maxLength < sb.length()) {
                        maxLength = sb.length();
                    }
                } else {
                   break;
                }

            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdefabcbbdefghijkl"));
    }
}
