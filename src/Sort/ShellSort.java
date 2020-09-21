package Sort;

public class ShellSort {
    public static int[] sort(int[] array){
        int length = array.length;
        int tmp,gap = length/2;
        while(gap>0){
            for(int i = gap;i<length;i++){
                tmp = array[i];
                int preIndex = i-gap;
                while(preIndex>=0 && array[preIndex]>array[i]){  //每一组里面的数据排序
                    array[preIndex+gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex+gap] = tmp;
            }
            gap = gap/2;
        }
        return array;
    }
}
