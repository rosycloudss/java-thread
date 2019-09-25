package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 * @author liwei-4
 * @description:
 * @date 2019-09-23
 */
public class Solution_113 {
    private int target;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        target = sum;
        helper(root, 0, result, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode node, int currentSum, List<List<Integer>> result, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        currentSum += node.val;

        if (node.left == null && node.right == null) {
            if (currentSum == target) {
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        helper(node.left,currentSum,result,list);
        helper(node.right,currentSum,result,list);
        list.remove(list.size() - 1);
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}