package hashmap.leetcode;

public class RansomNote {

    public static boolean canConstruct(String ransomNote,String magazine){
        for(int i=0;i<ransomNote.length();i++){
            if(magazine.contains(Character.toString(ransomNote.charAt(i)))){
                magazine=magazine.replaceFirst(Character.toString(ransomNote.charAt(i)),"0");
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa","ab"));
    }
}
