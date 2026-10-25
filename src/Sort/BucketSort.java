package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    // 桶排序：将数据均匀分配到 n 个桶中，桶内排序后拼接
    // 平均时间O(n+k)，适用于分布较均匀的浮点数
    public static double[] sort(double[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int n = array.length;
        double min = array[0], max = array[0];
        for (double v : array) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        if (min == max) {
            return array.clone();
        }
        List<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (double v : array) {
            int idx = (int) ((v - min) / (max - min) * (n - 1));
            buckets[idx].add(v);
        }
        double[] result = new double[n];
        int pos = 0;
        for (List<Double> bucket : buckets) {
            Collections.sort(bucket); // 桶内用比较排序
            for (double v : bucket) {
                result[pos++] = v;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[] arr = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};
        double[] sorted = sort(arr);
        System.out.print("桶排序结果: ");
        for (double v : sorted) {
            System.out.printf("%.2f ", v);
        }
        System.out.println();
    }
}
