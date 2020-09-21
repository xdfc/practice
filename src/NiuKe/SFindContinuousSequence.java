package NiuKe;
import java.util.ArrayList;
/**
 * 2020.5.21
 * 和为S的连续证正数序列
 * 思路：公差为1的等差数列和
 * 循环n从大到小
 * 算出a1，也就是第一项，判断第一项是不是整数
 * 是整数，则符合要求，从a1开始的连续n项就是一个arrayList
 */
public class SFindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        double a1 ;
        double x ;
        for(double n = sum;n>=2;n--){
            a1 = sum/n - (n-1)/2;
            if(a1<=0)
                continue;
            x = a1 - (int)a1;
            if(x==0){
                System.out.println("a1是整数");
                System.out.println("n:"+n+",a1:"+a1+",x:"+x);
                ArrayList<Integer> arrayList = new ArrayList<>();
                for(int i = 0;i<n;i++){
                    arrayList.add((int)a1+i);
                }
                arrayLists.add(arrayList);
            }
        }
        return arrayLists;
    }
}
