public class sumOfArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,10};
        System.out.print(recursive(nums, 0, 0));
    }
    private static int recursive(int[]nums, int sum, int ind){
        if(ind==nums.length) return sum;

        return recursive(nums, sum+nums[ind], ind+1);
    }
}
