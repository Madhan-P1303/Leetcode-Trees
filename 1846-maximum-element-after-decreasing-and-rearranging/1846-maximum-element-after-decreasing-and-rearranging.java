class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>c)c++;
        }
        return c;
    }
}