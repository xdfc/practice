package FileDemo;
/**
 * 列出目录结构
 * 递归调用指定目录下的所有目录
 *
 */

import java.io.File;
import java.io.IOException;

public class FileDemo2 {
    public static void main(String[] args) throws IOException {
        String path = "d:\\";
        File file = new File(path);
        listDir(file);
    }
    public static void listDir(File file){
        if(file.isDirectory()){
            File[] f = file.listFiles();
            if(f != null){
                for(int i = 0;i<f.length;i++){
                    listDir(f[i]);
                }
            }
        }
        System.out.println(file);
    }
}
