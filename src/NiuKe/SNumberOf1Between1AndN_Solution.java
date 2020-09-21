package NiuKe;
/**
 * 2020.4.15
 * 整数中1出现的次数
 * 思路：求出每一个数还有几个1，然后循环递减
 * 求出一个数有几个1的方法：如果n是个3位数，用n先除以100，在用余数除以10，再用余数除以1
 *
 */
public class SNumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int result = 0;
        int num = 1;
        while(n/num != 0){ //求出n个位数，n是3位数，num=1000；
            num = num*10;
        }
        while(n!=0){
            int tmp_n = n;
            int tmp_num = num;
            while(tmp_n!=0){  //求出每个数含有几个1
                tmp_num = tmp_num/10;
                if(tmp_n/tmp_num==1){
                    result++;
                }
                tmp_n=tmp_n%tmp_num; //获得余数
            }
            n--;
        }
        return result;
    }
}
