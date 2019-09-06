package leetcode;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Solution_70 {


//    int[] a;
//    public int climbStairs(int n) {
//        a = new int[n+1];
//        for (int i = 1;i <= n;i++){
//            a[i] = climbStair(i);
//        }
//        return a[n];
//    }
//
//    public int climbStair(int n){
//        if (n == 1){
//            return 1;
//        }
//        if (n == 2){
//            return 2;
//        }
//        return a[n-1] + a[n-2];
//    }

    /**
     * 由于每次最多爬两阶，楼梯的第i阶，只能从 第 i-1 阶和 i-2 阶到达，所以到达第i阶，只与第i-1阶和i-2阶的爬法数量有关
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int res=2;
        int before=1;
        int after=2;
        for(int i=3;i<=n;i++){
            res=before+after;
            before=after;
            after=res;
        }
        return res;
    }

}
