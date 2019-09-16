package leetcode;

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
        if (points == null) {
            return 0;
        }
        sort(points);
        int i = 0;
        int k = 0;
        while (i < points.length) {
            int start = points[i][0];
            int end = points[i][1];
            k++;
            if (i + 1 >= points.length) {
                break;
            }
            while (i + 1 < points.length && start <= end) {
                i++;
                if (points[i][0] <= end) {
                    start = points[i][0];
                }
                if (points[i][1] < end) {
                    end = points[i][1];
                }
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

        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(solution_452.findMinArrowShots(points));
    }
}
