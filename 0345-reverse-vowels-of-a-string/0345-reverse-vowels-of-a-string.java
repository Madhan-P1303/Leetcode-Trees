class Solution {
    public String reverseVowels(String s) {
      
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int n=s.length();
        char[] arr = s.toCharArray();
        int i=0;
        int j=n-1;
        while(i<j){
            while(i<j&&!set.contains(Character.toLowerCase(s.charAt(i)))){
                i++;
            }
            while(i<j&&!set.contains(Character.toLowerCase(s.charAt(j)))){
                j--;
            }
            char temp =arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

            i++;
            j--;
        }
        return new String(arr);
    }
}