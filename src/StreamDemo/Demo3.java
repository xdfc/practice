package StreamDemo;

import java.io.*;
import java.util.ArrayList;

public class Demo3 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        String path = "D:\\123.txt";
        File file = new File(path);
        Reader reader = new FileReader(file);
        BufferedReader bf = new BufferedReader(reader);
        String str;
        while((str = bf.readLine())!=null){
            arrayList.add(str);
        }
        bf.close();
        reader.close();
        for(int i = 0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println(arrayList);
    }
}
