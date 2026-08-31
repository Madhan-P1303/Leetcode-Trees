class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n==1)return 1;
        int min=nums[0];
        int max=nums[0];
        int ind1 = 0;
        int ind2 = 0;
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
                ind1=i;
            }
            if(nums[i]>max){
                max=nums[i];
                ind2=i;
            }
        }
        int a =Math.max(ind1,ind2)+1;
        int b=n-Math.min(ind1,ind2);
        int c=Math.min(ind1,ind2)+1 + (n-Math.max(ind1,ind2));

        return Math.min(a,Math.min(b,c));

    }
}