package DP;
/**
 * 动态规划
 * 三角形最大整数和
 *
 */
public class DP_TriangleMax {
    public static int DP(int[][] array){
        int[][] dp = new int[array.length][array.length];
        int max = 0;
        dp[0][0] = array[0][0];
        for(int i = 1;i<array.length;i++){
            for(int j = 0;j<i;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + array[i][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + array[i][j];
                }
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
