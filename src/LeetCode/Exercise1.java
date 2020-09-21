package LeetCode;

public class Exercise1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,8};
        System.out.println(twoSum(nums,11)[0]);
        System.out.println(twoSum(nums,11)[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}
