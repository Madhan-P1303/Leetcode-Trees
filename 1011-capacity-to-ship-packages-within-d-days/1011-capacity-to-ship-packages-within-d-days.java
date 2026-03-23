class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        for(int w:weights){
            left = Math.max(left,w);
            right+=w;
        }
        while(left<=right){
        
            int mid=(left+right)/2;
            int sum=0;
            int count=1;
            for(int w:weights){
                sum+=w;
                if(sum>mid){
                    count++;
                    sum=w;
                }
            }
            if(count<=days){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
            
        }
        return left;
    }
}