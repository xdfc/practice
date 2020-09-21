package DP;

import java.util.Scanner;
/**
 * 动态规划问题
 * 最短编辑距离
 * 链接：https://www.cnblogs.com/huststl/p/8664608.html
 */
public class DP_Leven {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String aStr = scan.nextLine();
        String bStr = scan.nextLine();
        int aLen = aStr.length();
        int bLen = bStr.length();
        int[][] dp = new int[aLen+1][bLen+1];
        for(int i=0;i<aLen+1;i++){
            dp[i][0] = i;
        }
        for(int i=0;i<bLen+1;i++){
            dp[0][i] = i;
        }
        for(int i=1;i<aLen+1;i++){
            for(int j=1;j<bLen+1;j++){
                if(aStr.charAt(i-1) == bStr.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
       System.out.println(dp[aLen][bLen]);
    }
}
