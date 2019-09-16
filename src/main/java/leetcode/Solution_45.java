package leetcode;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-16
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class Solution_45 {
    public int jump(int[] nums) {

        if (nums == null || nums.length == 1) {
            return 0;
        }

        int maxJump = nums[0];
        int jump = 0;
        if (maxJump >= nums.length-1){
            return 1;
        }
        int k = 1;
        while (maxJump < nums.length-1) {
            int temp = maxJump;
            int tempJump = jump;
            for (int i = tempJump; i <= temp; i++) {
                if (i + nums[i] > maxJump) {
                    maxJump = i + nums[i];
                    jump = i;
                }
            }
            if (maxJump == temp) {
                break;
            }
            k++;
        }

        return k;
    }
}
