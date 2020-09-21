//测试Scanner的next()和nextLine()接收方式

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
//next方式不管数字后面是多个空格还是enter都会等到接收下一个数字
/*        System.out.println("next方式接收：");
        if (scan.hasNext()){
            String str1 = scan.next();
            System.out.println("输入的数据为："+ str1);
        }*/

        System.out.println("nextLine方式接收：");
        if (scan.hasNextLine()){
            String str2 = scan.nextLine();  //接收第一行数据
            String str3 = scan.nextLine();  //enter换行后,接收第二行数据,有个scan.nextLine就接收几行数据
            System.out.println("输入的数据为："+ str2);
            System.out.println("输入的数据为："+ str3);
        }

        scan.close();
    }

}
