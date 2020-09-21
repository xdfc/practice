package Test;

/**
 * 定义一个一维数组，输出一维数组的逆序数组
 * 2020/2/5
 */

class ArrayU{
    public static void  exchange(int[] array){
 /*       //方法一：定义一个新的数组，逆序放入新的数组中，会产生垃圾空间
        int[] tmparray = new int[array.length];
        for(int i = 0;i<array.length;i++){
            tmparray[array.length-1-i] = array[i];
        }
        for(int i = 0;i<array.length;i++){
           array[i] = tmparray[i];
        }

  */
        //方法二：只在一个数组里面交换数据
        int tmp;
        for(int i=0;i<array.length/2;i++){
            tmp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = tmp;
        }
    }

    public static void show(int[] array){
        System.out.println("数组输出是:");
        for(int tmp:array){
            System.out.print(tmp+"\t");
        }
    }
}

public class ArrayExchange {
    public static void main(String[] args){
        int[] array = new int[] {1,2,3,4,5,6,7};
        ArrayU.exchange(array);
        ArrayU.show(array);
    }
}
