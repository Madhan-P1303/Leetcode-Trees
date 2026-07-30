class Solution {
    public int minimumPushes(String word) {
         int n=word.length();
         int res=0;
         if(n<=8){
            return n;
         }
         else if(n>8&&n<17){
            int num=n-8;
            res=8+num*2;
         }
         else if(n>16&&n<25){
            int num1=8;
            int num2=8*2;
            res=num1+num2+((n%16)*3);
         }
         else{
             int num1=8;
            int num2=8*2;
            int num3=8*3;
            res=num1+num2+num3+((n%24)*4);
            
         }
         return res;
    }
}