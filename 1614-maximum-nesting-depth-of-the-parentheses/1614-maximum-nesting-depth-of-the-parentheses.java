class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int ans=0;
        int res=0;
        for(char ch:s.toCharArray()){
            if(ch==')'){
           ans--;
            }
            if(ch=='('){
                ans++;
            }
            res=Math.max(res,ans);
        }
        return res;
    }
}