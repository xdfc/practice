package DP;

/**
 * 动态规划
 * 矩阵最大整数和
 */

public class DP_MatrixMax {
    //方法1
    public static int DP(int[][] array){
        int[][] dp = new int[array.length][array.length];
        int max = 0;
        dp[0][0] = array[0][0];
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array.length;j++){
                if(i==0&&j==0){
                    dp[i][j] = array[i][j];
                }else if(i==0){  //第一行，只能往前
                    dp[i][j] = dp[i][j-1] + array[i][j];
                }else if(j==0){  //第一列，只能忘上
                    dp[i][j] = dp[i-1][j] + array[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+array[i][j];
                }
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }
    //方法2
    public static int DP2(int[][] array,int i,int j){
        if(i==array.length-1&&j==array.length-1)
            return array[i][j];
        else if(i==array.length-1)
            return DP2(array,i,j+1)+array[i][j];
        else if(j==array.length-1)
            return DP2(array,i+1,j)+array[i][j];
        else
            return Math.max(DP2(array,i+1,j),DP2(array,i,j+1))+array[i][j];
    }
}
