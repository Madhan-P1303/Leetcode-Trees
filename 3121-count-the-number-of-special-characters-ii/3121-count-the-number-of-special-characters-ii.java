class Solution {
    public int numberOfSpecialChars(String word) {
        int n=word.length();
       int[] lowerLast = new int[26];
       int[] upperFirst = new int[26];
       Arrays.fill(lowerLast,-1);
       Arrays.fill(upperFirst,-1);
       for(int i=0;i<n;i++){
        char ch=word.charAt(i);
        if(Character.isLowerCase(ch)){
            lowerLast[ch-'a']=i;
        }else{
            if(upperFirst[ch-'A']==-1){
                upperFirst[ch-'A']=i;
            }
        }

       }
       int count=0;
       for(int i=0;i<26;i++){
        if(lowerLast[i]!=-1&&upperFirst[i]!=-1){
            if(lowerLast[i]<upperFirst[i]){
            count++;
        }
        }
       }
        return count;
    }
}