class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> upper = new HashSet<>();
        Set<Character> lower = new HashSet<>();
        for(char ch:word.toCharArray()){
            if(Character.isUpperCase(ch)){
                upper.add(ch);
            }
            else{
                lower.add(Character.toUpperCase(ch));
            }
        }
        int count=0;
        for(char sh:upper){
            if(lower.contains(sh)){
                count++;
            }
        }
        return count;
    }
}