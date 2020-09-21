package com.mani.stringmanipulation;

public class StringOperations {

    public static void main(String[] args) {
        StringUtil.findVowelCount("Hello");
        StringUtil.stringReverse("hello world");
        StringUtil.reverseWord("hello    world");
        StringUtil.removeDuplicateChars("hellloooo!");
        StringUtil.mostRepeated("helllooooo");
        StringUtil.firstLetterCaps("    trees are beautiful");
        StringUtil.anagramUsingArray("cdbb ","bbcd");
        StringUtil.palindrome("madam");
        StringUtil.areRotational("abcd","dabc");
    }
}
