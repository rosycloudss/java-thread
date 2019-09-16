package leetcode;

import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * @author liwei-4
 * @description:
 * @date 2019-09-16
 */
public class Solution_402 {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return "0";
        }
        char[] chars = new char[num.length()];
        int index = 0;
        for (int i = 0; i < num.length(); i++) {
            int number = num.charAt(i) - '0';
            while (index != 0 && k > 0 && (chars[index - 1] -'0') > number) {
                index--;
                k--;
            }
            if (number != 0 || index != 0) {
                chars[index++] = num.charAt(i);
            }
        }
        String result = new String(chars, 0, index - k);

        return result.equals("") ? "0" : result;
    }

    public static void main(String[] args) {
        Solution_402 solution_402 = new Solution_402();
        System.out.println(solution_402.removeKdigits("1432219",3 ));
    }
}
