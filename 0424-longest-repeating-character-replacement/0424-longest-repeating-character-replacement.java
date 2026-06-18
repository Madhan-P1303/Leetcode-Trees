class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        HashMap<Character,Integer> map = new HashMap<>();
          int left=0;
          int max=0;
          int res=0;
          for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            max=Math.max(max,map.get(ch));
            while((right-left+1)-max>k){
                char ch1=s.charAt(left);
                map.put(ch1,map.get(ch1)-1);
                left++;
            }
            res=Math.max(res,right-left+1);
          }
          return res;
    }
}