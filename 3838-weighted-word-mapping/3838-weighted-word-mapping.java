class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n=words.length;
        int m=weights.length;
        char[] alphabets = {
    'a','b','c','d','e','f','g','h','i','j','k','l','m',
    'n','o','p','q','r','s','t','u','v','w','x','y','z'
};
        String r="";
        
        int ans=0;
        for(String num:words){
            int sum=0;
            for(int i=0;i<num.length();i++){
                    char ch = num.charAt(i);
                    sum+=weights[ch-'a'];
            }
            ans=sum%26;
            r+=alphabets[26-ans-1];

        }
        return r;
    }
}