package StreamDemo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CharacterStreamDemo2 {
    public static void main(String[] args) throws IOException {
        File file =  new File("D:\\123.txt");
        if(file.exists()){
            Reader in = new FileReader(file);
            char data[] = new char[1024];  //创建一个字符数组
            int len = in.read(data);   //文件内容写入字符数组，返回长度
            System.out.println("读取内容："+new String(data,0,len));  //打印
        }
    }
}
