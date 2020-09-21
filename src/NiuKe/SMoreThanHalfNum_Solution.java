package NiuKe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * 2020.4.19
 * 数组中出现次数超过一半的数字
 * 思路：利用一个HashMap，以数组为key，出现次数为value
 * 遍历这个HashMap，Value大于数组长度一半的，返回其key值
 * 思路2：对数组先排序，用Arrays.sort();
 * 如果存在，则肯定是中间那个数，判断是否超过一半，不然就不存在
 */
public class SMoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(array[0],1); //初始放入一个
        for(int i = 1;i<array.length;i++){
            if(hashMap.containsKey(array[i])){  //如果有这个key值
                int value = hashMap.get(array[i]) + 1; //value加1
                hashMap.put(array[i],value);  //覆盖之前的<key,value>
            }else {
                hashMap.put(array[i],1);  //没有这个值，放入hashMap
            }
        }
        //遍历HashMap
        Set<Map.Entry<Integer,Integer>> set = hashMap.entrySet();
        Iterator<Map.Entry<Integer,Integer>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> map = iterator.next();
//            System.out.println("<"+map.getKey()+","+map.getValue()+">");
            int v = map.getValue();
            if(v>array.length/2){  //如果value值大于数组长度一半
                return map.getKey();  //返回key值
            }

        }
        return 0;  //没有返回0
    }
}
