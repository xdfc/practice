package Sort;

public class QuickSort {   //快速排序
    public static int[] quickSort(int[] array,int start,int end){
        if(array.length < 1 || start < 0 || end>=array.length || start > end) return null;
        int index = partition(array, start, end);
        if (index > start)
            quickSort(array, start, index - 1);
        if (index < end)
            quickSort(array, index + 1, end);
        return array;
    }

    public static int partition(int[] array,int start,int end){ //返回基准元素排序之后的位置，数组索引
//        int pivot = (int) (start + Math.random() * (end - start + 1));
//        swap(array, pivot, end);        //最后一个数最为基准数
        int smallIndex = start - 1;        //smallIndex表示前面比基准小的索引，直到出现一个数比基准大，索引停在前面
        for (int i = start; i <= end; i++){
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex){
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    public static void swap(int[] array,int i,int j){   //交换两个数组的数
        int tmp;
        tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
