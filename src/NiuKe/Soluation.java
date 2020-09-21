package NiuKe;

import java.util.ArrayList;
public class Soluation {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(input.length < k || k == 0)
            return list;

        for (int i = 0; i < k; i++)
            list.add(input[i]);

        for (int i = k; i < input.length; i++) {
            int j = this.getMax(list);
            int temp = (Integer) list.get(j);
            if (input[i] < temp)
                list.set(j, input[i]);
        }
        return list;
    }
    public int getMax(ArrayList<Integer> list) {
        int max = list.get(0);
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                j = i;
            }
        }
        return j;
    }
}
