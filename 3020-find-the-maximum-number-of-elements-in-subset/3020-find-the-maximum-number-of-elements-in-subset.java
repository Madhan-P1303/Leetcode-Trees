class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put((long) num, map.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        for (long x : map.keySet()) {

            // Special case for 1
            if (x == 1) {
                int cnt = map.get(1L);
                if (cnt % 2 == 0) cnt--;
                ans = Math.max(ans, cnt);
                continue;
            }

            long cur = x;
            int len = 0;

            while (map.getOrDefault(cur, 0) >= 2) {
                len += 2;
                cur = cur * cur;

                // prevent overflow
                if (cur > (long) 1e18) break;
            }

            if (map.containsKey(cur)) {
                len++;
            } else {
                len--;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}