package leetcode;

/**
 * @author liwei-4
 * @description:
 * @date 2019-10-08
 */
public class Solution_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                int left1 = mid;
                int right1 = mid;
                while (left1 >= 0 && nums[left1] == target) {
                    left1--;
                }
                result[0] = left1 + 1;
                while (right1 < nums.length && nums[right1] == target) {
                    right1++;
                }
                result[1] = right1 - 1;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
