package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 * <p>
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 *
 * @author liwei-4
 * @description:
 * @date 2019-09-26
 */
public class Solution_159 {
    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (; right < chars.length; right++) {
            Integer num = map.get(chars[right]);
            map.put(chars[right], num == null ? 1 : num + 1);
            if (map.size() > 2) {
                while (map.size() > 2 && left <= right) {
                    Integer charNum = map.get(chars[left]);
                    if (charNum - 1 == 0) {
                        map.remove(chars[left]);
                    } else {
                        map.put(chars[left], charNum - 1);
                    }
                    left++;
                }
            }
            max = max > right - left + 1 ? max : right - left + 1;
        }
        return max;
    }

    /**
     * 优化
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct1(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int[] digits = new int[256];
        int left = 0, right = 0, max = 0, numDigit = 0;
        char[] chars = s.toCharArray();
        for (; right < chars.length; right++) {
            if (digits[chars[right]] == 0) {
                numDigit++;
            }
            digits[chars[right]]++;
            while (numDigit > 2 && left <= right) {
                if ((--digits[chars[left]]) == 0) {
                    numDigit--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution_159 solution_159 = new Solution_159();
        System.out.println(solution_159.lengthOfLongestSubstringTwoDistinct1("abaccc"));
    }
}
