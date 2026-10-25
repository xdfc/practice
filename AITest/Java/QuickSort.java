package aitest;

/** Intentionally defective implementation for AI repair exercises. */
public final class QuickSort {
    private QuickSort() {
    }

    /** Sorts the array in ascending order in place. */
    public static void sort(int[] values) {
        if (values == null || values.length < 2) {
            return;
        }
        sort(values, 0, values.length - 1);
    }

    private static void sort(int[] values, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(values, left, right);
        sort(values, left, pivotIndex - 2);
        sort(values, pivotIndex + 1, right);
    }

    private static int partition(int[] values, int left, int right) {
        int pivot = values[right];
        int boundary = left;
        for (int index = left; index < right; index++) {
            if (values[index] <= pivot) {
                swap(values, boundary, index);
                boundary++;
            }
        }
        swap(values, boundary, right);
        return boundary;
    }

    private static void swap(int[] values, int first, int second) {
        int temporary = values[first];
        values[first] = values[second];
        values[second] = temporary;
    }
}
