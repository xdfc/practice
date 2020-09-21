package MathDemo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * 利用Random类生成一组彩票号码
 */
public class GenerateCaipiao {
    public static void main(String[] args) {
        int[] caipiao = new int[7];  //7个数字的彩票号码
        int foot = 0; //彩票数组下标
        Random random = new Random();
        while(foot!=7){
            int num = random.nextInt(31);  //生成一个不大于31的随机数
            if(isUse(num,caipiao)){
                caipiao[foot++] = num;
            }
        }
        Arrays.sort(caipiao);  //排序
        for(int tmp:caipiao){  //输出彩票号码
            System.out.print(tmp+"、");
        }
    }

    /**
     * 判断生成的随机数是否可用
     *  生成的数字不能为0，不能已经存在(重复)
     * @param num  生成的一个随机数
     * @param data  已经生成的一组数
     * @return 是否可用
     */
    public static boolean isUse(int num,int[] data){
        if(num == 0)
            return false;
        for(int tmp:data){
            if(num == tmp)
                return false;
        }
        return true;
    }
}
