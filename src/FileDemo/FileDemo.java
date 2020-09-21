package FileDemo;
/**
 * 简单的File类的方法应用
 * 创建一个文件的时候，其父目录必须存在
 */

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\1\\2");//创建文件其父目录必须存在
        if(!file.getParentFile().exists()){//判断父路径是否存在
            file.getParentFile().mkdirs(); //创建多个父路径文件夹
        }
        if(file.exists()){//文件存在
            file.delete(); //删除文件
        }else{//创建文件
            System.out.println(file.createNewFile());
        }
        System.out.println("是目录吗："+file.isDirectory());
        System.out.println("是文件吗："+file.isFile());
        if(file.isDirectory()){
            File[] f = file.listFiles(); //返回目录下的文件数组
            for(int i = 0;i<f.length;i++){
                System.out.println(f[i]);
            }
        }

    }
}
