package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-27
 */
public class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int max = Integer.MIN_VALUE;
        int left = 0;
        int[] a = new int[nums.length - k + 1];
        int i = 1;
        for (; i < k; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        a[0] = max;
        for (; i < nums.length; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }

            a[i - k + 1] = max;
        }
        return a;
    }
}
