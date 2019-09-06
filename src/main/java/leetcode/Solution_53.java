package leetcode;

/**
 *53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 */
public class Solution_53 {
    /**
     * 每次求解以第i个结尾的数字的最大和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (nums == null ||len == 0){
            return 0;
        }
        int dp[] = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1;i < len;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            if (max < dp[i]){
                max = dp[i];
            }
        }

        return max;
    }

}
