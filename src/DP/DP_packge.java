package DP;

/**
 * 动态规划
 * 背包问题
 */
public class DP_packge {
    public static void main(String[] args) {
        int v = 10;
        int N = 5;
        int[] weight = new int[]{3,5,3,4,2};
        int[] value = new int[]{1,3,2,4,2};
        System.out.println(ZeroOnePack2(v,N,weight,value));
    }
    /**
     * 0-1背包的优化解法
     * 思路：
     * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
     * 用逆序来实现
     * @param V 背包最大的重量
     * @param N 物品个数
     * @param weight 每个物品的重量
     * @param value 每个物品的价值
     * @return 最大的价值
     */
    public static int ZeroOnePack2(int V,int N,int[] weight,int[] value){
        //动态规划
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //逆序实现
            for(int j=V;j>=weight[i-1];j--){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
                System.out.print(j+"-"+dp[j] + "\t");
            }
            System.out.println("***********");
        }
        return dp[V];
    }

}
