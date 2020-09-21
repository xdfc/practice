package NiuKe;
/**
 * 2020.6.14
 * 剪绳子
 * 思路：创立一个数组，max[n]表示剪n段的最大值
 * 观察可以发现，剪n段的最大值为当n个数都一样大的时候最大
 *
 */

import java.util.Arrays;

public class ScutRope {
    public int cutRope(int target){
        int index = target/2+1;
        int[] max = new int[index];
        for(int i = 1;i<index+1;i++){
            max[i-1] = cutRope2(target,i);
        }
        Arrays.sort(max);  //对最大值数组排序，最后一个就是输出最大值
        return max[index-1];
    }

    /**
     * @param target  绳子长度
     * @param n  段数
     * @return 绳子剪n段的最大值
     */

    public int cutRope2(int target,int n){
        int max = 1;
        if(n==1)
            return 0;
        int[] k = new int[n];
        int m = n;
        for(int i = 0;i<m;i++){ //找到n个值
            k[i] = target/n;
            target = target - k[i];
            n--;
            max = max*k[i];
        }
        return max;
    }
}
