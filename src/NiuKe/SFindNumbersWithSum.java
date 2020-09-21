package NiuKe;

import java.util.ArrayList;

/**
 * 2020.5.21
 * 和为S的两个数
 * 思路：两层循环
 * 因为是递增，所以找到的第一组乘积最小
 */
public class SFindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array.length;j++){
                if(sum == array[i]+array[j]){
                    arrayList.add(array[i]);
                    arrayList.add(array[j]);
                    break;
                }
            }
            if(arrayList.size()!=0)
                break;
        }
        return arrayList;
    }
}
