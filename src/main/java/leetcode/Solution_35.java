package leetcode;

/**
 * @author liwei-4
 * @description:
 * @date 2019-10-08
 */
public class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (target < nums[0]) {
            return start;
        }
        if (target > nums[end]) {
            return end + 1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                if (mid + 1 < nums.length && target < nums[mid + 1]) {
                    return mid + 1;
                } else {
                    start = mid + 1;
                }
            } else if (target < nums[mid]) {
                if (mid - 1 > 0 && target > nums[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        Solution_35 solution_35 = new Solution_35();
        System.out.println(solution_35.searchInsert(arr,2));;
    }
}
