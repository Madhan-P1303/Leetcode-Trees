class Solution {
    public int gcdOfOddEvenSums(int n) {
        int a=0;
        int b=0;
        int i=1;
        while(i<=n+n){
            if((i%2)==0){
                b+=i;
                i++;
            }else{
                a+=i;
                i++;
            }
        }
 

        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}