class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int[] arr = new int[n];
        int m=0;
        while(m<n){
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                arr[m]=nums[i];
                m++;
            }
            
        }
        for(int i=0;i<n;i++){
            if(nums[i]==pivot){
                arr[m]=nums[i];
                m++;
            }
            
        }
        for(int i=0;i<n;i++){
            if(nums[i]>pivot){
                arr[m]=nums[i];
                m++;
            }
            
        }
        }
        return arr;
    }
}