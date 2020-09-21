package Sort;
import java.util.Arrays;

public class MergeSort {
    //归并排序
    public static int[] sort(int[] array){
        if(array.length<2) return array;
        int mid = array.length/2;
        int[] left = Arrays.copyOfRange(array,0,mid);  //取数组的左半部分
        int[] right = Arrays.copyOfRange(array,mid,array.length);//取数组的右半部分
        return merge(sort(left),sort(right));   //递归迭代，直到数据长度为2，利用if(array.length<2) return array;结束递归调用
    }

    //将两段排序的数组合并成为一个数组
    public static int[] merge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        for(int index = 0,i=0,j=0;index<result.length;index++){//index是输出元素的下标，i，j分别是左右数组的下标
            if(i>=left.length){   //如果左边的数组判断结束了，剩下的只需要把右边数组的元素赋值就行
                result[index] = right[j];
                j++;
            }else if(j>=right.length){
                result[index] = left[i];
                i++;
            }else if(left[i]<right[j]){        //如果左边的数组元素小，取左边的，指针i右移1
                result[index] = left[i];
                i++;
            }else {   //如果右边的元素小，取右边的，指针i右移1
                result[index] = right[j];
                j++;
            }
        }
        return result;
    }

}
