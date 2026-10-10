package Sort;

public class CountingSort {
    // 计数排序：适用于取值范围不大的整数排序，时间O(n+k)，空间O(k)，稳定
    public static int[] sort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int min = array[0], max = array[0];
        for (int v : array) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        int[] count = new int[max - min + 1];
        for (int v : array) {
            count[v - min]++;
        }
        // 前缀和，保证稳定性
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] result = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            result[--count[array[i] - min]] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 9, 2, 7, 3, 0, -4, 6};
        int[] sorted = sort(arr);
        System.out.print("计数排序结果: ");
        for (int v : sorted) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
