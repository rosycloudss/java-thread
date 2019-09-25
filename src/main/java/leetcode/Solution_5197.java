package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 * @author liwei-4
 * @description:
 * @date 2019-09-25
 */
public class Solution_5197 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length <= 1) {
            return result;
        }
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        list.add(arr[1]);
        result.add(list);
        for (int i = 2; i < arr.length; i++) {
            int cha = arr[i] - arr[i - 1];
            if (cha > min) {
                continue;
            } else if (cha == min) {
                list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                result.add(list);
            } else {
                result.clear();
                list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                result.add(list);
                min = cha;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution_5197 solution_5197  = new Solution_5197();
        int[] arr = new int[]{40,11,26,27,-20};
        solution_5197.minimumAbsDifference(arr);
    }
}
