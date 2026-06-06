class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        int sum=0;
        for(int i=1;i<n;i++){
            sum+=nums[i-1];
            dp[i]=sum;
        }
        int sum2=0;
        for(int i=n-2;i>=0;i--){
            sum2+=nums[i+1];
            dp[i]=Math.abs(dp[i]-sum2);
        }
        return dp;
    }
}