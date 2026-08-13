class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int left=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[left]=nums[i];
                left++;
            }
        }
        for(int j=left;j<n;j++){
            nums[j]=0;
        }
    }
}