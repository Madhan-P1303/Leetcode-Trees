class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int n = patterns.length;
        int count=0;
        for(String s:patterns){
            if(word.contains(s)){
                count++;
            }
        }
        return count;
    }
}