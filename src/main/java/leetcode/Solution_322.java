package leetcode;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class Solution_322 {
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        for (int i = 0; i <= amount; i++) {
//            dp[i] = -1;
//        }
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int j = 0; j < coins.length; j++) {
//                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
//                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]]) {
//                        dp[i] = dp[i - coins[j]] + 1;
//                    }
//                }
//            }
//        }
//        return dp[amount];
//    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        helper(coins, amount, coins.length - 1, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int result = Integer.MAX_VALUE;
    private void helper(int[] coins, int target, int idx, int cur) {
        if (idx < 0) return;
        if (target % coins[idx] == 0) { result = Math.min(result, cur + target / coins[idx]); return; }

        for (int i = target / coins[idx]; i >= 0; --i) {
            if (cur + i >= result - 1) return;
            helper(coins, target - i * coins[idx], idx -  1, cur + i);
        }
    }
}
