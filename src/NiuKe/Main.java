package NiuKe;
/**
 * 2020.5.1
 * 阿里笔试补做
 * 文杰
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String result = "C:\\log.txt";
        FileInputStream fstream = new FileInputStream(new File(result));
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        Map<String, String> map = new HashMap<String, String>();
        while((strLine = br.readLine()) != null){
            String[] temp = strLine.split(",");
            map.put(temp[2],strLine);
        }
        Set<String> keySet = map.keySet();
        Object[] array = keySet.toArray();
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        List<String> res = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            res.add(map.get(array[i]));
        }
        System.out.println(res.toString());
    }

}