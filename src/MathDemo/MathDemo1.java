package MathDemo;

import java.util.Random;

/**
 * 一些简单的Math数学方法
 * 实现一个可以四舍五入的Math方法
 */


class MathUtil{
    /**
     * 实现数据的四舍五入
     * @param number 要进行四舍五入的数据
     * @param scale  四舍五入保留的位数
     * @return  返回四舍五入后的数字
     */
    public static double round(double number, int scale){
        return Math.round(number*Math.pow(10,scale))/Math.pow(10,scale);
    }
}


public class MathDemo1 {
    public static void main(String[] args) {
        System.out.println(Math.abs(-12));   //12 绝对值
        System.out.println(Math.round(-15.4));  //-15  四舍五入，加上0.5后向下取整，就是Math.floor(x+0.5)
        System.out.println(Math.round(-15.51)); //-16
        System.out.println(Math.floor(1.4)); //1 向下取整
        System.out.println(Math.ceil(1.4)); //2 向上取整
        System.out.println(Math.pow(10,2));  //100 10的2次方
        System.out.println(Math.log(15));  //对数
        System.out.println(Math.max(-10.1,-9));  //-9  最大值
        System.out.println(Math.random());  // 0-1的随机数
        //四舍五入
        System.out.println(MathUtil.round(10.228,2));
        //Random类
        Random random = new Random();
        for(int i = 0;i<10;i++){
            System.out.print(random.nextInt(10)+"、"); //随机生成不大于10，包括0的随机数
        }

    }
}
