package NiuKe;

/**
 * 2020.6.17
 * 机器人的运动范围
 * 题目好像有问题，理解有误
 */
public class SmovingCount {
    public int movingCount(int threshold, int rows, int cols){
        int time = 0; //移动次数
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(sum(i)+sum(j)>threshold)
                    break;
                if(sum(i)+sum(j)<=threshold){
                    time++;
                    System.out.println("i:"+i+",j:"+j);
                }
            }
        }
        return time;
    }

    /**
     *
     * @param number  横坐标或者纵坐标
     * @return  数位之和
     */

    public int sum(int number){
        int i = 100;
        int sum = 0;
        while(i!=0){
            sum = sum + number/i;
            number = number%i;
            i = i/10;
        }
        return sum;
    }
}
