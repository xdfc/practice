package StreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamDemo2 {
    public static void main(String[] args) throws IOException{
        File file = new File("D:\\123.txt");
        if(!file.getParentFile().exists()){ //父目录不存在创建父目录
            file.getParentFile().mkdirs();
        }
        InputStream inputStream = new FileInputStream(file);
        byte[] data = new byte[100];
        int len  = inputStream.read(data);  //将文件内容读取到字节数组中，并返回读取的字节数组长度
        System.out.println(new String(data,0,len)); //字节数组换为String类型，并且打印出来
    }
}
