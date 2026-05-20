class Solution {
    public int destroyTargets(int[] nums, int space) {
        int n=nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int mod =nums[i]%space;
            map.put(mod,map.getOrDefault(mod,0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)->a.getValue()-b.getValue());
        int maxfreq=list.get(list.size()-1).getValue();

        List<Integer> keys = new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            if(list.get(i).getValue()==maxfreq){
                keys.add(list.get(i).getKey());
            }

        }
        int ans=Integer.MAX_VALUE;
        for(int num:nums){
            int remainder = num%space;
            if(keys.contains(remainder)){
                ans=Math.min(ans,num);
            }
        }
        return ans;
    }
}