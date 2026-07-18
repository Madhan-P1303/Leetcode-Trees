class Solution {
    public int findGCD(int[] nums) {
        int n=nums.length;
        int a=Integer.MAX_VALUE;
        int b=Integer.MIN_VALUE;

        for(int num:nums){
            a=Math.min(a,num);
            b=Math.max(b,num);
        }
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}