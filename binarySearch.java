public class binarySearch {
    public static void main(String[] args) {
        int[] nums = {2,5,7,9,12,15,18,20};
        int target = 18;

        System.out.print(recursive(nums, target, 0,nums.length-1));
    }
    private static int recursive(int[]nums, int target, int ind,int last){
        if(nums[ind] == target) return ind;

        int mid = (ind+last)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return recursive(nums, target, ind+1, mid-1);
        else return recursive(nums, target, mid+1, last);

    }
}
