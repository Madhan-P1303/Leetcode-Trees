class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int left =0;
        double sum=0;
        double res = Double.NEGATIVE_INFINITY;
        double avg=0;
        int ky=0;
        if(n==1)return (double) nums[0];
        for(int right=0;right<n;right++){
                    sum+=nums[right];
                
                    if(right-left+1>k){
                   sum-=nums[left];
                   left++;
                    }
                    if(right-left+1==k){
                    avg=sum/k;
                    res = Math.max(res,avg);
                    }
        }
                  return res;
    }
}