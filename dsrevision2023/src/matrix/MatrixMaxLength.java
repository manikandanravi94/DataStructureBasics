package matrix;

import java.util.Arrays;

public class MatrixMaxLength {

    public static int[][] getMax(int[][] grid) {
        int innerLength = grid[0].length-2;
        int[][] output = new int[grid.length - 2][innerLength];
        for (int k = 0; k < innerLength; k++) {
            for (int m = 0; m < innerLength; m++) {
                for (int i = k; i < k + 3; i++) {
                    for (int j = m; j < m+3; j++) {
                        output[k][m] = Math.max(output[k][m], grid[i][j]);
                    }
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] input = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        Arrays.asList(getMax(input)).forEach(ints -> System.out.println(Arrays.toString(ints)));
    }
}
