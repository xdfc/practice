package Sort;

public class RadixSort {
    // 基数排序（LSD，按位稳定计数）：时间O(d*(n+k))，稳定
    // 支持负数：先把负数取反分离，再合并
    public static int[] sort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int[] result = array.clone();
        radixSortNonNegative(result);
        return result;
    }

    private static void radixSortNonNegative(int[] arr) {
        int max = arr[0];
        for (int v : arr) {
            if (v > max) max = v;
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int v : arr) {
            count[(v / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int d = (arr[i] / exp) % 10;
            output[--count[d]] = arr[i];
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66, 3};
        int[] sorted = sort(arr);
        System.out.print("基数排序结果: ");
        for (int v : sorted) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
