/**
 * 输入一行数字，分别把整数放入数组k[],小数放入数组f[]中
 * 输入任意非数字表示结束输出
 */

import java.util.Scanner;

public class SannerTest {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int j = 0;
        int[] k = new int[10];
        float[] f = new float[10];
        while(scan.hasNext()){
            if(scan.hasNextInt()){
                k[i] = scan.nextInt();
                i++;
            }else if(scan.hasNextFloat()){
                f[j] = scan.nextFloat();
                j++;
            }else{
                break;
            }
        }
        System.out.println("输入的整数是：");
        for(int a=0;a<i;a++){
            System.out.print(k[a]+"\t");
        }
        System.out.println();
        System.out.println("输入的小数是" );
        for(int a=0;a<j;a++){
            System.out.print(f[a]+"\t");
        }
    }
}
