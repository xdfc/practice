package DP;

/**
 * 动态规划经典问题
 * 1. 最长公共子序列（Longest Common Subsequence, LCS）
 * 2. 最长递增子序列（Longest Increasing Subsequence, LIS）
 */
public class DP_LCS_LIS {

    public static void main(String[] args) {
        DP_LCS_LIS demo = new DP_LCS_LIS();

        // 测试最长公共子序列
        System.out.println("=== 最长公共子序列测试 ===");
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        int lcsLength = demo.longestCommonSubsequence(s1, s2);
        System.out.println("字符串1: " + s1);
        System.out.println("字符串2: " + s2);
        System.out.println("最长公共子序列长度: " + lcsLength);
        System.out.println("最长公共子序列: " + demo.getLCS(s1, s2));
        System.out.println();

        // 测试最长递增子序列
        System.out.println("=== 最长递增子序列测试 ===");
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int lisLength = demo.lengthOfLIS(nums);
        System.out.print("数组: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("最长递增子序列长度: " + lisLength);
    }

    /**
     * 最长公共子序列 - 动态规划解法
     * 问题描述：给定两个字符串，求它们的最长公共子序列的长度
     *
     * 状态转移方程：
     * dp[i][j] 表示 s1[0...i-1] 和 s2[0...j-1] 的最长公共子序列长度
     *
     * 如果 s1[i-1] == s2[j-1]:
     *     dp[i][j] = dp[i-1][j-1] + 1
     * 否则:
     *     dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 最长公共子序列的长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }

        int m = text1.length();
        int n = text2.length();

        // dp[i][j] 表示 text1[0...i-1] 和 text2[0...j-1] 的LCS长度
        int[][] dp = new int[m + 1][n + 1];

        // 填充dp数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 字符相同，长度加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 字符不同，取两种情况的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 获取最长公共子序列的字符串（不仅是长度）
     * 通过回溯dp数组来构造LCS
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 最长公共子序列字符串
     */
    public String getLCS(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return "";
        }

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 构建dp数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 回溯构造LCS字符串
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                // 字符相同，加入LCS
                lcs.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // 因为是从后往前构造的，需要反转
        return lcs.reverse().toString();
    }

    /**
     * 最长递增子序列 - 动态规划解法
     * 问题描述：给定一个整数数组，找到其中最长递增子序列的长度
     *
     * 状态转移方程：
     * dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
     *
     * 对于每个 i，遍历 j < i：
     *     如果 nums[i] > nums[j]:
     *         dp[i] = max(dp[i], dp[j] + 1)
     *
     * 时间复杂度：O(n^2)
     *
     * @param nums 整数数组
     * @return 最长递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        // dp[i] 表示以 nums[i] 结尾的最长递增子序列长度
        int[] dp = new int[n];

        // 初始化，每个元素自己就是长度为1的递增子序列
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        int maxLength = 1;

        // 填充dp数组
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果 nums[i] > nums[j]，可以将 nums[i] 接在以 nums[j] 结尾的递增子序列后
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    /**
     * 最长递增子序列 - 二分查找优化版
     * 使用贪心 + 二分查找，时间复杂度：O(n log n)
     *
     * 思路：维护一个数组 tails，tails[i] 表示长度为 i+1 的递增子序列的最小末尾元素
     *
     * @param nums 整数数组
     * @return 最长递增子序列的长度
     */
    public int lengthOfLIS_Optimized(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // tails[i] 表示长度为 i+1 的递增子序列的最小末尾元素
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            // 二分查找插入位置
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = num;
            if (left == size) {
                size++;
            }
        }

        return size;
    }
}
