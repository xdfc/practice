package Sort;

public class SelectSort {
    public static void sort(int[] array){
        for(int i = 0;i<array.length;i++){
            int minIndx = i;
            for(int j = i;j<array.length;j++){
                if(array[j]<array[minIndx]){   //找出最小的数
                    minIndx = j;   //将最小数的索引保存
                }
            }
            int tmp = array[i];
            array[i] = array[minIndx];
            array[minIndx] = tmp;
        }
    }
}
