package NiuKe;
/**
 * 2020.4.15
 * 把数组排成最小的数
 * 思路：定义一个新的大小，两个数n和m，判断是nm小还是mn小，确定更小的数，返回索引
 * 利用选择排序的思想，每次找到最小的数，放在最前面，然后将“重新排好序”的数组连成字符串
 *
 */
public class SPrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        String result = "";
        for(int i = 0;i<numbers.length;i++){
            int minIndex = i;
            for(int j = i;j<numbers.length;j++){
                minIndex = Min(numbers[minIndex],minIndex,numbers[j],j);
            }
            //交换最小的数和第i个数
            int tmp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = tmp;
            result = result + numbers[i]; //数字连接成字符

        }
        return result;
    }

    public int Min(int n,int n1,int m,int m1){ //两个数以及其索引
        Integer i = n;
        Integer j = m;
        String str1 = i.toString()+j.toString();  //两种组合方式
        String str2 = j.toString()+i.toString();
        if(Integer.parseInt(str1)<Integer.parseInt(str2)){  //返回小的那个索引
            return n1;
        }else{
            return m1;
        }
    }
}
