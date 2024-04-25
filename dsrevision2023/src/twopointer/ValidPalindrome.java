package twopointer;

public class ValidPalindrome {
        public static boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                if(Character.isLetter(s.charAt(i))){
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
            }
            String output=sb.toString();
            int length=output.length()-1;
            for(int i=0;i<output.length()/2;i++){
              if(output.charAt(i)!=output.charAt(length-i)){
                  return false;
              }
            }
            return true;
        }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

}
