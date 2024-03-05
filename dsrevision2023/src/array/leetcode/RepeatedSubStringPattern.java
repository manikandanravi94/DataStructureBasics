package array.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RepeatedSubStringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abaababaab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        StringBuilder k = new StringBuilder();
        int length = 1;
        Set<String> checkSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = Character.toString(s.charAt(i));
            if (!checkSet.contains(temp)) {
                checkSet.add(temp);
                k.append(temp);
            } else {
                break;
            }
        }
        length = k.length();
        if (s.length() % length != 0)
            return false;
        for (int i = length; i <=s.length() - length; i = i + length) {
            String temp=s.substring(i, i + length);
            if (!k.toString().equals(temp)) {
                return false;
            }
        }
        return true;
    }
}
