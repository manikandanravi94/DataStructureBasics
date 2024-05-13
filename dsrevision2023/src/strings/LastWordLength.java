package strings;

public class LastWordLength {

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length()-s.lastIndexOf(" ")-1;
    }

    public static void main(String[] args) {
        String k = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(k));
    }
}
