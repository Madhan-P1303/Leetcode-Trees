class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int n = s.length();
        int m = p.length();

        List<Integer> list = new ArrayList<>();

        if (m > n) return list;

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int count = m;

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    count--;
                }

                map.put(ch, map.get(ch) - 1);
            }

            if (right - left + 1 > m) {

                char ch1 = s.charAt(left);

                if (map.containsKey(ch1)) {

                    if (map.get(ch1) >= 0) {
                        count++;
                    }

                    map.put(ch1, map.get(ch1) + 1);
                }

                left++;
            }

            if (count == 0) {
                list.add(left);
            }
        }

        return list;
    }
}