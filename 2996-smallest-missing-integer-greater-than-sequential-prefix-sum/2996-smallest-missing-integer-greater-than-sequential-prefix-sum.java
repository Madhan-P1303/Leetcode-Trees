class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0]+1;
        }
        int max = nums[0];
        int res=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]==(nums[i-1]+1)){
                max+=nums[i];
                res=Math.max(res,max);
            }
            else{
                break;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        while(set.contains(res)){
            res++;
        }
  return res;
    }
}