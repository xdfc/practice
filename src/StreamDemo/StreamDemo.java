package StreamDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StreamDemo {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\123.txt");  //指定要操作的文件路径
        OutputStream out = new FileOutputStream(file,true);  //通过子类实例化,true表示追加
        String str = "hello world\r\n";  //要输出的内容
        out.write(str.getBytes());  //将字符串变为字节数组并输出
        out.close(); //关闭
    }
}
