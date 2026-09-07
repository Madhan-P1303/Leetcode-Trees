class Solution {
    public int distinctSubseqII(String s) {
        int mod=1000000007;
        int total=0;
        int[] dp = new int[26];
        for(int i=0;i<s.length();i++){
         int ch = s.charAt(i)-97;
         int add = (total-dp[ch]+mod)%mod;

         dp[ch]=1+total;
         total=(dp[ch]+add)%mod;
        }
        return total;
    }
}