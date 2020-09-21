package Sort;

public class TestSort {
    public static void main(String[] args){
        int[] array = new int[]{0,1,8,9,8,6,10,78,2,56,2};
//        int[] array1 = sort(array);
        quickSort(array,0,array.length-1);

        for(int tmp:array){
            System.out.print(tmp + "\t");
        }
//        System.out.print(array.length);
    }
    public static void quickSort(int a[],int l,int r){
        if(l >= r)
            return;
        int key = a[l];
        int i = l;
        int j = r;
        while(i<j){
            while(i<j && key<a[j]){
                j--;
            }
            if(i<j){
                a[i] = a[j];
                i++;
            }

            while(i<j && key>a[i]){
                i++;
            }
            if(i<j){
                a[j] = a[i];
                j--;
            }

        }
        a[i] = key;
        quickSort(a,0,i-1);
        quickSort(a,i+1,r);
    }

}
