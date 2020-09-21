package NiuKe;

import java.util.Arrays;

/**
 * 2020.4.8
 * 连续子数组的最大和
 * 思路：最简单的方法就是用两层循环解决，增加一些判断，提高效率
 * 还可以利用动态规划的思想
 */
public class SFindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0)
            return 0;
        if(array.length==1)  //只有一个值，则只返回这一个值
            return array[0];
        int max = array[0];
        int[] maxsum = new int[array.length]; //存放每次累加最大的和
        for(int i = 0;i<array.length;i++){
            int sum = 0;  //注意这个变量的位置
            maxsum[i] = array[i];
            for(int j = i;j<array.length;j++){
                sum = sum + array[j];
                if(sum<0){   //如果累加和小于0，则后面停止累加
                    break;
                }
                if(maxsum[i]<sum){
                    maxsum[i] = sum;
                }
            }
            if(max<maxsum[i]){
                max = maxsum[i];
            }
        }
        return max;
    }
}
