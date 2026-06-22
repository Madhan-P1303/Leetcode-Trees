class Solution {
    public int maxNumberOfBalloons(String text) {
        int n=text.length();
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        
         String s="balloon";
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:text.toCharArray()){
             map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:s.toCharArray()){
            if(!map.containsKey(ch)){
                return 0;
            }else{
                if(ch=='b'||ch=='a'||ch=='n'){
                    min1=Math.min(min1,map.get(ch));
                }
                else if(ch=='l'||ch=='o'){
                    min2=Math.min(min2,map.get(ch));
                }
            }
        }
       
        return Math.min(min1,min2/2);
    }
}