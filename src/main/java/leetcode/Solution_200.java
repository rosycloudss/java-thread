package leetcode;

import java.util.LinkedList;

/**
 * @author liwei-4
 * @description:
 * @date 2019-09-29
 */
public class Solution_200 {
    int row = 0, col = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || (row = grid.length) == 0 || (col = grid[0].length) == 0) {
            return 0;
        }
        int result = 0;
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (grid[y][x] == '1') {
                    result++;
                    BNS(grid, x, y);
                }

            }
        }
        return result;
    }


    public void BNS(char[][] grid, int x, int y) {
        grid[y][x] = '0';
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int nodex = node.x;
            int nodey = node.y;
            if (nodex + 1 < col && grid[nodey][nodex + 1] == '1') {
                grid[nodey][nodex + 1] = '0';
                queue.push(new Node(nodex + 1, nodey));
            }
            if (nodex - 1 >= 0 && grid[nodey][nodex - 1] == '1') {
                grid[nodey][nodex - 1] = '0';
                queue.push(new Node(nodex - 1, nodey));
            }
            if (nodey + 1 < row && grid[nodey + 1][nodex] == '1') {
                grid[nodey + 1][nodex] = '0';
                queue.push(new Node(nodex, nodey + 1));
            }
            if (nodey - 1 >= 0 && grid[nodey - 1][nodex] == '1') {
                grid[nodey - 1][nodex] = '0';
                queue.push(new Node(nodex, nodey - 1));
            }
        }

    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void DNS(char[][] grid, int x, int y) {

        if (x < 0 || x >= col || y < 0 || y >= row || grid[y][x] == '0') {
            return;
        }
        grid[y][x] = '0';
        DNS(grid, x - 1, y);
        DNS(grid, x + 1, y);
        DNS(grid, x, y - 1);
        DNS(grid, x, y + 1);

    }

    public static void main(String[] args) {
        char[][] data = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(new Solution_200().numIslands(data));
    }
}
