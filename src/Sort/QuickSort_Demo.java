package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序详细Demo
 * 包含多种快排实现方式：
 * 1. 标准快速排序（基于分区）
 * 2. 三路快排（处理大量重复元素）
 * 3. 随机化快排（避免最坏情况）
 */
public class QuickSort_Demo {

    public static void main(String[] args) {
        QuickSort_Demo demo = new QuickSort_Demo();

        // 测试标准快排
        System.out.println("=== 标准快速排序测试 ===");
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90, 88, 45, 50};
        System.out.print("原始数组: ");
        printArray(arr1);
        demo.quickSort(arr1, 0, arr1.length - 1);
        System.out.print("排序后: ");
        printArray(arr1);
        System.out.println();

        // 测试三路快排（含重复元素）
        System.out.println("=== 三路快速排序测试（含重复元素）===");
        int[] arr2 = {4, 5, 3, 2, 4, 3, 5, 2, 3, 4, 4, 5};
        System.out.print("原始数组: ");
        printArray(arr2);
        demo.quickSort3Way(arr2, 0, arr2.length - 1);
        System.out.print("排序后: ");
        printArray(arr2);
        System.out.println();

        // 测试随机化快排
        System.out.println("=== 随机化快速排序测试 ===");
        int[] arr3 = {9, 8, 7, 6, 5, 4, 3, 2, 1}; // 逆序数组是标准快排的最坏情况
        System.out.print("原始数组（逆序）: ");
        printArray(arr3);
        demo.quickSortRandom(arr3, 0, arr3.length - 1);
        System.out.print("排序后: ");
        printArray(arr3);
        System.out.println();

        // 性能比较
        System.out.println("=== 性能比较测试 ===");
        demo.performanceTest();
    }

    /**
     * 标准快速排序
     *
     * 算法思想：
     * 1. 选择一个基准元素（pivot）
     * 2. 将数组分为两部分：小于基准的在左边，大于基准的在右边
     * 3. 对左右两部分递归进行快速排序
     *
     * 时间复杂度：
     * - 平均: O(n log n)
     * - 最好: O(n log n)
     * - 最坏: O(n²) - 当数组已经有序时
     *
     * 空间复杂度: O(log n) - 递归栈空间
     *
     * @param arr 待排序数组
     * @param left 左边界
     * @param right 右边界
     */
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // 分区，返回基准元素的最终位置
        int pivotIndex = partition(arr, left, right);

        // 递归排序左右两部分
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    /**
     * 分区函数 - Lomuto分区方案
     *
     * 思路：
     * 1. 选择最右边的元素作为基准
     * 2. 维护一个指针i，表示小于基准的区域的最后一个位置
     * 3. 遍历数组，如果当前元素小于基准，将其与i+1位置交换
     * 4. 最后将基准放到正确位置
     *
     * @param arr 数组
     * @param left 左边界
     * @param right 右边界
     * @return 基准元素的最终位置
     */
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 选择最右边的元素作为基准
        int i = left - 1; // i表示小于基准的区域的最后一个位置

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // 将基准元素放到正确位置
        swap(arr, i + 1, right);
        return i + 1;
    }

    /**
     * Hoare分区方案（另一种经典分区方法）
     *
     * 思路：
     * 1. 选择第一个元素作为基准
     * 2. 使用两个指针从两端向中间扫描
     * 3. 左指针找大于基准的元素，右指针找小于基准的元素
     * 4. 交换这两个元素，直到两指针相遇
     *
     * @param arr 数组
     * @param left 左边界
     * @param right 右边界
     * @return 分区点
     */
    private int partitionHoare(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left - 1;
        int j = right + 1;

        while (true) {
            // 从左向右找大于等于基准的元素
            do {
                i++;
            } while (arr[i] < pivot);

            // 从右向左找小于等于基准的元素
            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    /**
     * 三路快速排序（3-Way QuickSort）
     *
     * 适用场景：数组中有大量重复元素时效率更高
     *
     * 算法思想：
     * 将数组分为三部分：
     * - [left, lt) : 小于基准
     * - [lt, gt]   : 等于基准
     * - (gt, right]: 大于基准
     *
     * 优点：对于有很多重复元素的数组，可以达到线性时间复杂度O(n)
     *
     * @param arr 待排序数组
     * @param left 左边界
     * @param right 右边界
     */
    public void quickSort3Way(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = arr[left]; // 选择第一个元素作为基准
        int lt = left;         // arr[left+1...lt] < pivot
        int gt = right;        // arr[gt...right] > pivot
        int i = left + 1;      // arr[lt+1...i-1] == pivot

        while (i <= gt) {
            if (arr[i] < pivot) {
                // 当前元素小于基准，交换到左边
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i] > pivot) {
                // 当前元素大于基准，交换到右边
                swap(arr, i, gt);
                gt--;
                // 注意：此时不移动i，因为交换来的元素还未处理
            } else {
                // 当前元素等于基准，移动到下一个
                i++;
            }
        }

        // 将基准元素放到正确位置
        swap(arr, left, lt);

        // 递归排序小于和大于基准的部分（等于基准的部分已经在正确位置）
        quickSort3Way(arr, left, lt - 1);
        quickSort3Way(arr, gt + 1, right);
    }

    /**
     * 随机化快速排序
     *
     * 优点：通过随机选择基准元素，避免最坏情况的发生
     * 即使输入数组已经有序，也能达到O(n log n)的期望时间复杂度
     *
     * @param arr 待排序数组
     * @param left 左边界
     * @param right 右边界
     */
    public void quickSortRandom(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partitionRandom(arr, left, right);
        quickSortRandom(arr, left, pivotIndex - 1);
        quickSortRandom(arr, pivotIndex + 1, right);
    }

    /**
     * 随机化分区函数
     *
     * @param arr 数组
     * @param left 左边界
     * @param right 右边界
     * @return 基准元素的最终位置
     */
    private int partitionRandom(int[] arr, int left, int right) {
        // 随机选择一个元素作为基准
        Random random = new Random();
        int randomIndex = left + random.nextInt(right - left + 1);

        // 将随机选择的元素交换到最右边
        swap(arr, randomIndex, right);

        // 使用标准分区方法
        return partition(arr, left, right);
    }

    /**
     * 交换数组中两个元素
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     */
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * 性能测试
     * 比较不同快排实现在不同数据集上的性能
     */
    private void performanceTest() {
        int size = 10000;

        // 测试1：随机数组
        System.out.println("测试1：随机数组（10000个元素）");
        int[] randomArr = generateRandomArray(size);
        testSortingTime("标准快排", randomArr.clone());
        testSortingTime("三路快排", randomArr.clone());
        testSortingTime("随机化快排", randomArr.clone());
        System.out.println();

        // 测试2：大量重复元素
        System.out.println("测试2：大量重复元素（10000个元素，只有10个不同值）");
        int[] duplicateArr = generateArrayWithDuplicates(size, 10);
        testSortingTime("标准快排", duplicateArr.clone());
        testSortingTime("三路快排", duplicateArr.clone());
        testSortingTime("随机化快排", duplicateArr.clone());
        System.out.println();

        // 测试3：已排序数组（快排的最坏情况）
        System.out.println("测试3：已排序数组（10000个元素）");
        int[] sortedArr = generateSortedArray(size);
        // 注意：标准快排在已排序数组上会很慢，所以使用较小的数组
        testSortingTime("随机化快排", sortedArr.clone());
        System.out.println("（跳过标准快排测试，因为已排序数组是其最坏情况）");
    }

    /**
     * 测试排序时间
     */
    private void testSortingTime(String method, int[] arr) {
        long startTime = System.nanoTime();

        switch (method) {
            case "标准快排":
                quickSort(arr, 0, arr.length - 1);
                break;
            case "三路快排":
                quickSort3Way(arr, 0, arr.length - 1);
                break;
            case "随机化快排":
                quickSortRandom(arr, 0, arr.length - 1);
                break;
        }

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // 转换为毫秒
        System.out.printf("%s 耗时: %.2f ms\n", method, duration);
    }

    /**
     * 生成随机数组
     */
    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    /**
     * 生成含有大量重复元素的数组
     */
    private int[] generateArrayWithDuplicates(int size, int uniqueValues) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(uniqueValues);
        }
        return arr;
    }

    /**
     * 生成已排序数组
     */
    private int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
