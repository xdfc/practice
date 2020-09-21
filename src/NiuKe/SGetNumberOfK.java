package NiuKe;

/**
 * 2020.5.1
 * 数组在排序数组中出现的次数
 * 二分查找找到最左边的索引，再找到最右边的索引
 * 然后相减
 * 改完之后对了
 */
public class SGetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length==0)
            return 0;
        int end = KIndex2(array,k);
        int start = KIndex1(array,k);
        if(start!=-1&&end!=-1){
            return end-start+1;
        }
        return 0;
    }
    //获得相同数字最左边的索引
    public int KIndex1(int[] array, int k){
        int index = array.length/2;
        int l = 0;
        int r = array.length-1;  //注意要-1
        while(l<=r){
            if(array[index]<k){
                l = index + 1;
            }else if(array[index]>k){
                r = index - 1;
            }else if(index>0&&array[index-1]==k){
                r = index - 1;
            }else{
                return index;
            }
            index = (l+r)/2;
        }
        return -1;
    }
    //获得相同数字最右边的索引
    public int KIndex2(int[] array, int k){
        int index = array.length/2;
        int l = 0;
        int r = array.length-1; //注意要-1
        if(k<array[0])
            return -1;
        while(l<=r){
            if(array[index]<k){
                l = index + 1;
            }else if(array[index]>k){
                r = index - 1;
            }else if(index+1<array.length&&array[index+1]==k){
                l = index + 1;
            }else{
                return index;
            }
            index = (l+r)/2;
        }
        return -1;
    }
}

