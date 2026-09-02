class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        int count=0;
        for(int i=0;i<n;i++){
             if(nums1[i]%2==0){
                count++;
             }
             else{
               count++;
             }
        }
        if(count==n){
            return true;
        }
        return true;
    }
}