package aitest;

/** Intentionally defective implementation for AI repair exercises. */
public final class BinarySearch {
    private BinarySearch() {
    }

    public static int find(int[] sortedValues, int target) {
        int low = 0;
        int high = sortedValues.length;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (sortedValues[middle] == target) {
                return middle;
            }
            if (sortedValues[middle] < target) {
                low = middle;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
