package leetcode;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-12
 */
public class Solution_64 {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int col = grid[0].length; //列
        int row = grid.length; //行
        int[][] dp = new int[row][col];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[row - 1][col - 1];
    }
}
