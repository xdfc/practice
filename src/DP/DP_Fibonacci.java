package DP;

/**
 * 动态规划
 * 斐波拉契数列
 * F(n)=F(n-1)+F(n-2),F(1)=F(2)=1;
 * 最简单的动态规划
 */
public class DP_Fibonacci {
    public int Fibonacci(int n){
        if(n==1||n==2)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);  //F(n)=F(n-1)+F(n-2)
    }
}
