package Sort;

/**
 * 快速排序示例
 * 时间复杂度：平均O(nlogn)，最坏O(n^2)
 * 空间复杂度：O(logn)
 * 不稳定排序
 */
public class QuickSort {

    /**
     * 快速排序主方法
     * @param array 待排序数组
     * @param start 开始索引
     * @param end 结束索引
     * @return 排序后的数组
     */
    public static int[] quickSort(int[] array, int start, int end){
        if(array.length < 1 || start < 0 || end >= array.length || start > end)
            return null;

        // 获取基准元素的最终位置
        int index = partition(array, start, end);

        // 递归排序左半部分
        if (index > start)
            quickSort(array, start, index - 1);

        // 递归排序右半部分
        if (index < end)
            quickSort(array, index + 1, end);

        return array;
    }

    /**
     * 分区函数：将数组分为小于基准和大于基准两部分
     * @param array 数组
     * @param start 开始索引
     * @param end 结束索引
     * @return 基准元素的最终位置
     */
    public static int partition(int[] array, int start, int end){
        // 选择最后一个元素作为基准
        int pivot = array[end];

        // smallIndex指向小于基准的最后一个元素的位置
        int smallIndex = start - 1;

        // 遍历数组，将小于等于基准的元素移到左边
        for (int i = start; i <= end; i++){
            if (array[i] <= pivot) {
                smallIndex++;
                if (i > smallIndex){
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    /**
     * 交换数组中两个元素的位置
     * @param array 数组
     * @param i 第一个元素索引
     * @param j 第二个元素索引
     */
    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 打印数组
     * @param array 要打印的数组
     */
    public static void printArray(int[] array){
        for(int num : array){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * 测试示例
     */
    public static void main(String[] args) {
        // 测试用例1：普通数组
        System.out.println("=== 测试用例1：普通数组 ===");
        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("排序前：");
        printArray(array1);
        quickSort(array1, 0, array1.length - 1);
        System.out.print("排序后：");
        printArray(array1);

        // 测试用例2：包含重复元素的数组
        System.out.println("\n=== 测试用例2：包含重复元素 ===");
        int[] array2 = {5, 2, 8, 2, 9, 1, 5, 5};
        System.out.print("排序前：");
        printArray(array2);
        quickSort(array2, 0, array2.length - 1);
        System.out.print("排序后：");
        printArray(array2);

        // 测试用例3：已排序数组
        System.out.println("\n=== 测试用例3：已排序数组 ===");
        int[] array3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("排序前：");
        printArray(array3);
        quickSort(array3, 0, array3.length - 1);
        System.out.print("排序后：");
        printArray(array3);

        // 测试用例4：逆序数组
        System.out.println("\n=== 测试用例4：逆序数组 ===");
        int[] array4 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.print("排序前：");
        printArray(array4);
        quickSort(array4, 0, array4.length - 1);
        System.out.print("排序后：");
        printArray(array4);

        // 测试用例5：单个元素
        System.out.println("\n=== 测试用例5：单个元素 ===");
        int[] array5 = {42};
        System.out.print("排序前：");
        printArray(array5);
        quickSort(array5, 0, array5.length - 1);
        System.out.print("排序后：");
        printArray(array5);
    }

}
