package ByteDance;
/**
 * 字节跳动一面的手撕代码
 * 但是说了思路就没写了
 * 下面是一种实现方式
 * 题目：找出数组第k个大的数字的索引
 */

import java.util.Arrays;
import java.util.HashMap;

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,4};
        System.out.println(index(arr,6));
        int[] arr1 = {5,1,3,5,4};
        System.out.println(index(arr1,3));
        int[] arr2 = {1,1,1,1,5};
        System.out.println(index(arr2,2));
    }

    public static int index(int[] arr,int k){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int tmp = k;
        for(int i = 0;i<arr.length;i++){
            hashMap.put(arr[i],i);
        }
        Arrays.sort(arr);
        int j = arr.length - 1;
        while(j > 0){
            if((j>=1)&&arr[j]!=arr[j-1]){
                k--;
                if(k==0)
                    break;
            }
            j--;
        }
        if(k==tmp-1)  //k只移动了1次
            return 0;
        if(j==0&&k!=0)  //没有第K个大的数
            return -1;
        int a = hashMap.get(arr[j]);
        return a;
    }
}
