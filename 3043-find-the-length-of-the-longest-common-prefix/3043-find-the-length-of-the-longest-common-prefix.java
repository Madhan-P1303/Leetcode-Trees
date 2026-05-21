class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n=arr1.length;
        int m=arr2.length;
        Set<Integer> set = new HashSet<>();
        for(int num:arr1){
              while(num>0){
                set.add(num);
                num=num/10;
              }
        }
        int max=0;
        for(int num1:arr2){
            while(num1>0){
            if(set.contains(num1)){
                int length=String.valueOf(num1).length();
                max=Math.max(max,length);
                break;

            }
            num1=num1/10;
        }
        }
        return max;
    }
}