class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int[] nums = new int[n];
        nums[0]=1;
        int max= nums[0];
        for(int i=1;i<n;i++){
            if(Math.abs(nums[i-1]-arr[i])<=1){
                nums[i]=arr[i];
                max=Math.max(max,nums[i]);
            }
            else{
                nums[i]=nums[i-1]+1;
                max=Math.max(max,nums[i]);
            }
        }
      return max;
    }
}