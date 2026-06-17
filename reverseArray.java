public class reverseArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int n = nums.length;

         reverse(nums, 0, n-1);

        for(int num:nums){
            System.out.print(num+ " ");
        }
        //System.out.print(reverse(nums,0, n-1));
    }
    private static int[] reverse(int[]nums,int ind, int n){
        //if(n==0) return nums;
        if(ind>=n) return nums;

        
            int temp = nums[ind];
            nums[ind] = nums[n];
            nums[n] = temp;
        
        return reverse(nums, ind+1, n-1);
    }
}
