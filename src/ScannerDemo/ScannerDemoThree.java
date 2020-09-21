import java.util.Scanner;

public class ScannerDemoThree {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //将输入的数据按空格分隔成字符串数组，
        // 注意如果有多个连续空格，会全部删除，但是第一个连续的空格会删除，后面的连续空格为null
        String[] str = s.nextLine().split(" ");
        for(int j=0;j<str.length;j++){
            System.out.print(Integer.parseInt(str[j]));  //数字字符串转换成int类型数据
        }
        System.out.println(str.length);
        /*
        int n = s.nextInt();
        for(int i = 0;i<n;i++){
            String str = s.nextLine(); //只会接收n-1行数据，因为第一次接收了n，按enter之后，就相当于运行了一次
        }
         */
    }
}
