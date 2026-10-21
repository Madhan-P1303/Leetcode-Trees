class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int min=s.charAt(0);
        boolean st=true;
        int max=s.charAt(0);
        for(int i=1;i<n;i++){
            if(s.charAt(i)<s.charAt(i-1)){
                st=false;
            }
            if(s.charAt(i)<min){
                min=s.charAt(i);
            }
            if(s.charAt(i)>max){
                max=s.charAt(i);
            }
        }
        if(st){
            return 0;
        }
        if(n==2){
            return -1;
        }
        if(s.charAt(0)==min||s.charAt(n-1)==max){
            return 1;
        }
       for(int i=1;i<n-1;i++){
        if(s.charAt(i)==min || s.charAt(i)==max){
            return 2;
        }
       }
       return 3;
    }
}