package NiuKe;
/**
 * 2020.5.1
 * 阿里笔试补做
 * 张鑫
 */

import java.io.*;
import java.util.*;

public class Main_1 {

    public static List<String> getFile(String path){
        ArrayList<String> strArray = new ArrayList<>();
        try {
            File filename = new File(path);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while(line != null) {
                strArray.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strArray;
    }

    public static void main(String[] args) {
        List<String> list = getFile("d:/3.txt");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<list.size(); i++){

            String s = list.get(i);
            int location = s.indexOf("ms");
            int j = location-1;
            while (s.charAt(j)>='0' && s.charAt(j)<='9'){
                j--;
            }
            int timeCost = Integer.parseInt(s.substring(j+1, location));
            map.put(s, timeCost);
        }

        //将Hashmap转换成List进行排序
        List<Map.Entry<String, Integer>> tmpList = new ArrayList<>(map.entrySet());
        Collections.sort(tmpList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : tmpList){
            System.out.println(entry.getKey());
        }
    }
}