package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-16
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。
 * 开始坐标总是小于结束坐标。平面内最多存在104个气球。
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。
 * 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * Example:
 * <p>
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 */
public class Solution_452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int i = 1;
        int k = 1;
        int end = points[0][1];
        for (; i < points.length; i++) {
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                k++;
                end = points[i][1];
            }
        }
        return k;
    }

    public void sort(int[][] points) {
        int sorted = 0; // sorted 之前的元素已经拍好序了
        for (int i = 0; i < points.length - 1; i++) {
            int s = 0;
            for (int j = points.length - 1; j > sorted; j--) {
                if (points[j][0] < points[j - 1][0]) {
                    int[] temp = points[j];
                    points[j] = points[j - 1];
                    points[j - 1] = temp;
                    s = j - 1;
                }
            }
            sorted = s;
            if (sorted == points.length) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution_452 solution_452 = new Solution_452();

        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(solution_452.findMinArrowShots(points));
    }
}
