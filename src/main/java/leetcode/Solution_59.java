package leetcode;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author liwei-4
 * @description:
 * @date 2019-09-26
 */
public class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int k = 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                result[up][i] = k++;
            }
            if (++up > down) break;
            for (int i = up; i <= down; i++) {
                result[i][right] = k++;
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                result[down][i] = k++;
            }
            if (--down < up) break;
            for (int i = down; i >= up; i--) {
                result[i][left] = k++;
            }
            if (++left > right) break;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_59 solution_59 = new Solution_59();
        int[][] result = solution_59.generateMatrix(3);

    }
}
