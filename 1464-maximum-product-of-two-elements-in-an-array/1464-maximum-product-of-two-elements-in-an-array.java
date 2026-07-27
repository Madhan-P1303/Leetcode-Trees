class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int num1=nums[n-1]-1;
        int num2=nums[n-2]-1;
        return num1*num2;
        
    }
}