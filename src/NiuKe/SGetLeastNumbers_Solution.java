package NiuKe;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 2020.4.8
 * 最小的K个数
 * 思路：先对前k个数字排序，然后后面的依次进行比较，如果比排序的最后一个小
 *      就交换这两个数
 * 最后输出不排序好像也是可以的，所以下面代码中排序部分其实可以不排序
 * 直接就将前k个数放入arrayList中去
 * 思考：
 */
public class SGetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(k>input.length){
            return arrayList;
        }
        for(int i = 0;i<input.length;i++){
            if(i<k){
                for(int j = i;j<k;j++){      //对前k个元素排序
                    if(input[i]>input[j]){
                        int tmp = input[i];
                        input[i] = input[j];
                        input[j] = tmp;
                    }
                }
            }else{
                int index = k-1;
                if(input[i]<input[k-1]){
                    while(index>=0&&input[i]<input[index]){
                        index--;
                    }
                    int tmp = input[index+1];
                    input[index+1] = input[i];
                    input[i] = tmp;
                    i = i-1;  //往前移1位，交换的数字需要重新判断
                }
            }
        }
        for(int tmp: Arrays.copyOfRange(input,0,k)){
            arrayList.add(tmp);
            System.out.print(tmp+"\t");
        }
        return arrayList;
    }
}
