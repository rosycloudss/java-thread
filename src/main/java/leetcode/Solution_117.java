package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * <p>
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 * <p>
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 * @author liwei-4
 * @description:
 * @date 2019-09-24
 */
public class Solution_117 {
    // 层次遍历
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node pre = nodes.poll();
            int cur = nodes.size();
            if (pre.left != null) nodes.add(pre.left);
            if (pre.right != null) nodes.add(pre.right);
            while (cur > 0) {
                Node node = nodes.poll();
                pre.next = node;
                pre = node;
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
                cur--;
            }
        }
        return root;
    }
}
