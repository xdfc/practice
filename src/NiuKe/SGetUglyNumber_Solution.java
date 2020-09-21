package NiuKe;

/**
 * 2020.4.18
 * 丑数
 * 思路：穷举，一个一个加，测试是不是丑数，是的index--；
 * 直到找到第index个丑数
 * 错误，算法复杂度太高了
 * 另外一个思路：
 * 新建一个数组有序放入丑数，
 * 第一个丑数为1，后面每次放入一个数，这个数是乘上2,3或5得到的最小数
 */
public class SGetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
            return 0;
        int[] result = new int[index];
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        result[0] = 1;
        for(int i= 1;i<index;i++){
            int x1 = result[i1]*2;
            int x2 = result[i2]*3;
            int x3 = result[i3]*5;
            int tmp = min(x1,min(x2,x3)); //将最小的丑数放入数组
            if(tmp==x1) i1++; //如果丑数来自某一个指针，指针加1
            if(tmp==x2) i2++;
            if(tmp==x3) i3++;
            result[i] = tmp;
        }
        return result[index-1];
    }
    public int min(int x1,int x2){
        return (x1<x2)?x1:x2;
    }


    //时间复杂度高，但是空间复杂度低，不需要新的数组
    /*
    public int GetUglyNumber_Solution(int index) {
        int tmp_num = 1;
        int num = 1;
        if(index==1)
            return 1;
        while(index!=1){
            num = ++tmp_num;   //每次加1
            while(true){  //循环判断这是否是一个丑数
//                System.out.print(num+"\t");
                //是否能被2，3或5整除，可以整除，获得余数再判断
                if(num%2==0){
                    num = num/2;
                }else if(num%3==0){
                    num = num/3;
                }else if(num%5==0){
                    num = num/5;
                }else if(num == 1){ //是一个丑数
                    index--;
                    break;  //跳出循环
                }else if(num%2!=0&&num%3!=0&&num%5!=0){ //不是一个丑数
                    break;  //跳出循环
                }
            }
//            System.out.println();
        }
        return tmp_num;
    }

     */

}
