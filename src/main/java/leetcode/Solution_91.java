package leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * @description:
 * @date 2019-09-27
 */
public class Solution_91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        int num = Integer.parseInt(s.substring(0, 2));
        if (s.charAt(1) == '0') {
            if (num <= 26) {
                dp[1] = 1;
            } else {
                return 0;
            }
        } else {
            if (num <= 26) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
        }
        for (int i = 2; i < n; i++) {
            int x = s.charAt(i - 1) - '0';
            int y = s.charAt(i) - '0';
            int xy = x * 10 + y;
            if (xy >= 10 && xy <= 26) {
                if (y != 0) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 2];
                }
            } else if (xy == 0 || (xy > 26 && y == 0)) {
                return 0;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {

    }
}
