package Sort;

public class BubbleSort {
    public static void sort(int[] array){
        int tmp;
        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array.length-1-i;j++){
                if(array[j] > array[j+1]){
                    tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

}
