package Test; /**
 * 输入第一个数n，计算n!
 * 同时输出1!+2!+...+n!的结果
 */
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args){
        int n = 0;
        int l = 0;
        Scanner scan = new Scanner(System.in);
        if(scan.hasNextInt()){
            n = scan.nextInt();
        }
        System.out.println(n+"的阶乘是"+factorial(n));
        for( ;n>=1;n--){
            l = factorial(n)+l;
        }
        System.out.println("阶乘累加和是"+l);

    }
    public static int factorial(int n){
        int k=1;
        for( ;n>=1;n--){
            k =k *n;
        }
        return k;
    }
}
