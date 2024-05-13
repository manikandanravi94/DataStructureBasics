package matrix;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public static boolean isValidSudoku(char[][] board){
        for(int i=0;i<board.length;i++){
            Set<Character> x = new HashSet<>();
            Set<Character> y = new HashSet<>();
            for(int j=0;j<board.length;j++){
                char xVal = board[i][j];
                char yVal=board[j][i];
                if('.'!=xVal){
                    if(x.contains(xVal)){
                        return false;
                    }else{
                        x.add(xVal);
                    }}
                if('.'!=yVal){
                    if(y.contains(yVal)){
                        return false;
                    }else{
                        y.add(yVal);
                    }
                }
            }
            if(x.isEmpty()||y.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] input = {{'.','.','.','.','5','.','.','1','.'},
                          {'.','4','.','3','.','.','.','.','.'},
                          {'.','.','.','.','.','3','.','.','1'},
                          {'8','.','.','.','.','.','.','2','.'},
                          {'.','.','2','.','7','.','.','.','.'},
                          {'.','1','5','.','.','.','.','.','.'},
                          {'.','.','.','.','.','2','.','.','.'},
                          {'.','2','.','9','.','.','.','.','.'},
                          {'.','.','4','.','.','.','.','.','.'}};
        System.out.println(isValidSudoku(input));
    }
}
