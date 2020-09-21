package Test;

/**
 * 对一维数组进行升序排序
 * 如果数组已经按照升序排序之后，那么跳出循环
 */
class ArrayUnti{
    public static void sort(int arr[]){
        for (int j = 0; j < arr.length; j++) {   //外层循环
            int k=0;   //判断是否升序的变量
            for (int i = 0; i < arr.length - j-1; i++) {
//          for (int i = 0; i < array.length - j- 1; i++) {  //如果写成这种形式则是减少内层循环的次数，不需要判断是否已经完成排序
                int tmp = 0;
                if (arr[i] > arr[i + 1]) {  //如果前一个值比后一个值大，则交换前后数据
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }else{
                    k++;  //如果数组已经升序排序，则k值为数组长度减去1
                }
            }
            if(k == arr.length-1){
                break;  //结束外层循环，减少外层循环次数
            }
            System.out.println("第" + j + "次排序的结果为：");
            for (int tmp : arr) {
                System.out.print(tmp + "\t");
            }
            System.out.println(k);
        }
    }
    public static void show(int arr[]){
        for (int tmp : arr) {
            System.out.print(tmp + "\t");
        }
    }

}

public class ArraySort {
    public static void main(String[] args) {
        int[] array = new int[]{8,9,0,2,3,5,10,7,6,1};   //初始化一维数组
        ArrayUnti.sort(array);  //排序数组
        System.out.println("最终的排序结果是：");
        ArrayUnti.show(array);  //输出数组
    }
}