class Solution {
    public int minimumPushes(String word) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int[] arr = new int[map.size()];
        List<Integer> list = new ArrayList<>();
        for(char ch:map.keySet()){
            list.add(map.get(ch));
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(list.size()-i-1);
        }
        int res=0;
        for(int i=0;i<arr.length;i++){
              int ans = (i/8)+1;
                res = res + (arr[i]*ans);
        }
        return res;
    }
}