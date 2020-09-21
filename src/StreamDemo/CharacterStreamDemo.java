package StreamDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharacterStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\1\\123.txt");
        if(!file.getParentFile().exists()){ //父目录不存在创建父目录
            file.getParentFile().mkdirs();
        }
        Writer out = new FileWriter(file);  //子类向上转型
        String str = "hello java";
        out.write(str);   //向文件里面写入string
        out.append("hahahha");  //向文件里面追加内容
        out.close();
    }
}
