class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> answer = new HashSet<>();
         for(int num:nums1){
             if(bS(nums2,num)){
                answer.add(num);
             }
         }
         int[] arr = new int[answer.size()];
         int index=0;
         for(int x:answer){
            arr[index++]=x;
         }

       return arr;

    }
    private boolean bS(int[] arr, int target){
        int n=arr.length;
        int left =0;
        int height = arr.length-1;
         while(left<=height){
            int mid =(left+height)/2;
            if(arr[mid]==target){
                return true;
            }
            else if(target<arr[mid]){
                height=mid-1;
            }
            else{
                left=mid+1;
            }

         }
           return false;
    }
}