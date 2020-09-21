package Sort;

public class InsertSort {
    public static void sort(int[] array){
        int current;

        for (int i = 0;i<array.length-1;i++){  //认为第一个元素是排好的i=0
            current = array[i+1];  //取出排好的后一个元素
            int preIndex = i;   //排好元素的最后一个索引
            while(preIndex >=0 && current<array[preIndex]){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] =current;
        }
    }
}
