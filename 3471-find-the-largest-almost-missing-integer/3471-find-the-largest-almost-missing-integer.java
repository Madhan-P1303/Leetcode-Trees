class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<=n-k;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<i+k;j++){
                    set.add(nums[j]);
            }
            for(int num:set){
               map.put(num,map.getOrDefault(num,0)+1);
            }
            
        }
        
      
        int res = -1;
        for(int num:nums){
            if(map.get(num)==1){
             res = Math.max(res,num);
            }
        }
        return res;
    }
}