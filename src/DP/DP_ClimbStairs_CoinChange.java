package DP;

import java.util.Arrays;

/**
 * 动态规划经典问题
 * 1. 爬楼梯问题
 * 2. 硬币找零问题
 * 3. 最小路径和
 */
public class DP_ClimbStairs_CoinChange {

    public static void main(String[] args) {
        DP_ClimbStairs_CoinChange demo = new DP_ClimbStairs_CoinChange();

        // 测试爬楼梯问题
        System.out.println("=== 爬楼梯问题测试 ===");
        int n = 10;
        System.out.println("爬" + n + "级楼梯的方法数: " + demo.climbStairs(n));
        System.out.println();

        // 测试硬币找零问题
        System.out.println("=== 硬币找零问题测试 ===");
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.print("硬币面额: ");
        for (int coin : coins) {
            System.out.print(coin + " ");
        }
        System.out.println();
        System.out.println("总金额: " + amount);
        System.out.println("最少硬币数: " + demo.coinChange(coins, amount));
        System.out.println("组合方式数: " + demo.coinChangeWays(coins, amount));
        System.out.println();

        // 测试最小路径和
        System.out.println("=== 最小路径和问题测试 ===");
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println("网格:");
        for (int[] row : grid) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println("最小路径和: " + demo.minPathSum(grid));
    }

    /**
     * 爬楼梯问题 - 动态规划解法
     * 问题描述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。有多少种不同的方法可以爬到楼顶？
     *
     * 状态转移方程：
     * dp[i] 表示爬到第 i 阶的方法数
     * dp[i] = dp[i-1] + dp[i-2]
     * 因为可以从 i-1 阶爬1阶到达，或从 i-2 阶爬2阶到达
     *
     * 初始状态：
     * dp[1] = 1 (只有一种方法)
     * dp[2] = 2 (两种方法：1+1 或 2)
     *
     * @param n 楼梯的阶数
     * @return 爬到楼顶的方法数
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // 空间优化：只需要保存前两个状态
        int prev2 = 1; // dp[i-2]
        int prev1 = 2; // dp[i-1]
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    /**
     * 硬币找零问题 - 最少硬币数
     * 问题描述：给定不同面额的硬币 coins 和一个总金额 amount。
     * 计算可以凑成总金额所需的最少的硬币个数。
     *
     * 状态转移方程：
     * dp[i] 表示凑成金额 i 所需的最少硬币数
     * dp[i] = min(dp[i], dp[i - coin] + 1)  对所有可用的 coin
     *
     * 初始状态：
     * dp[0] = 0 (金额为0不需要硬币)
     * dp[i] = Integer.MAX_VALUE (其他金额初始化为无穷大)
     *
     * @param coins 硬币面额数组
     * @param amount 总金额
     * @return 最少硬币数，如果无法凑成返回-1
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        // dp[i] 表示凑成金额 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 初始化为一个不可能的大值
        dp[0] = 0;

        // 遍历所有金额
        for (int i = 1; i <= amount; i++) {
            // 尝试每种硬币
            for (int coin : coins) {
                if (i >= coin) {
                    // 可以使用这种硬币
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果dp[amount]仍然是初始值，说明无法凑成
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 硬币找零问题 - 组合方式数
     * 问题描述：给定不同面额的硬币和一个总金额，
     * 计算有多少种不同的组合方式可以凑成这个金额。
     *
     * 状态转移方程：
     * dp[i] 表示凑成金额 i 的组合数
     * dp[i] += dp[i - coin]  对所有可用的 coin
     *
     * @param coins 硬币面额数组
     * @param amount 总金额
     * @return 组合方式数
     */
    public int coinChangeWays(int[] coins, int amount) {
        if (amount < 0) {
            return 0;
        }

        // dp[i] 表示凑成金额 i 的组合数
        int[] dp = new int[amount + 1];
        dp[0] = 1; // 凑成0元有1种方式（不选任何硬币）

        // 外层遍历硬币，内层遍历金额（避免重复计数）
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    /**
     * 最小路径和问题
     * 问题描述：给定一个 m x n 的网格，包含非负整数，
     * 找出一条从左上角到右下角的路径，使得路径上的数字总和最小。
     * 每次只能向下或向右移动一步。
     *
     * 状态转移方程：
     * dp[i][j] 表示从左上角到 (i,j) 的最小路径和
     * dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
     *
     * 边界条件：
     * dp[0][0] = grid[0][0]
     * dp[i][0] = dp[i-1][0] + grid[i][0] (第一列只能从上方来)
     * dp[0][j] = dp[0][j-1] + grid[0][j] (第一行只能从左方来)
     *
     * @param grid 二维网格
     * @return 最小路径和
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        // 直接在原数组上修改，节省空间
        // 如果不能修改原数组，可以创建新的dp数组

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // 填充其他位置
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }

    /**
     * 最小路径和问题 - 不修改原数组版本
     */
    public int minPathSum_NoModify(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 填充其他位置
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
