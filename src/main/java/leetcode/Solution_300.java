package leetcode;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-12
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * 创建 temp 数组 保存最长上升序列，
     * 堆原序列进行遍历，将每位元素二分插入到temp中，如果 temp 中的元素逗比它小，将它插到最后
     * 否则，用它覆盖比他大的元素中最小的那个
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] temp = new int[len];
        temp[0] = nums[0];
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > temp[end]) {
                end++;
                temp[end] = nums[i];
            } else {
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (temp[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                temp[left] = nums[i];
            }
        }
        return end + 1;
    }
}
