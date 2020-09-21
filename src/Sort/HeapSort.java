package Sort;

public class HeapSort {
    //声明全局变量
    static int len;

    public static int[] heapSort(int[] array){
        len = array.length-1;  //因为数组是从0开始索引，所以长度-1，后面容易理解
        if(len<0)return array;
        buildMaxHeap(array);//构建一个最大堆
//循环将堆首位(最大值)与末位交换，然后重新调整最大值
        while(len>=0){
            QuickSort.swap(array,0,len);  //最大的元素放到最后
            len--;
//  A:          adjustHeap(array,0);   //从上往下构建，需要最后一个递归
            buildMaxHeap(array);   //从最后一个非叶子节点，构建最大堆
        }
        return array;
    }
//建立最大堆
    public static void buildMaxHeap(int[] array){
        //从最后一个非叶子节点开始向上构造最大堆
        //for循环这样写会更好一点：i的左子树和右子树分别2i+1和2(i+1)
        for(int i=(len+1)/2-1;i>=0;i--){
            adjustHeap(array,i);
        }
    }
//调整使之成为最大堆
    public static void adjustHeap(int[] array,int i) {
        int maxIndex = i;  //最大值索引
        //下面两个if就是为了找出一个节点下的最大值索引
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 + 1  <= len && array[i * 2 +1 ] > array[maxIndex])
            maxIndex = i * 2 +1 ;   //指向左节点
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 2 <= len && array[i * 2 +2] > array[maxIndex])
            maxIndex = i * 2 + 2;   //指向右节点
        //如果父节点不是最大值，则将父节点与最大值交换，。
        if (maxIndex != i) {
            QuickSort.swap(array, maxIndex, i);  //交换数据
//  A:          adjustHeap(array, maxIndex);  //并且递归调整与父节点交换的位置
        }
    }
}
