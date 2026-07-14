class Solution {

    static final int MOD = 1000000007;
    Integer[][][] dp;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][201][201];
        return solve(0, 0, 0, nums);
    }

    private int solve(int idx, int g1, int g2, int[] nums) {

        if (idx == nums.length) {
            return (g1 != 0 && g2 != 0 && g1 == g2) ? 1 : 0;
        }

        if (dp[idx][g1][g2] != null)
            return dp[idx][g1][g2];

        long ans = 0;

        // Put current element into seq1
        ans += solve(idx + 1,
                g1 == 0 ? nums[idx] : gcd(g1, nums[idx]),
                g2,
                nums);

        // Put current element into seq2
        ans += solve(idx + 1,
                g1,
                g2 == 0 ? nums[idx] : gcd(g2, nums[idx]),
                nums);

        // Ignore current element
        ans += solve(idx + 1, g1, g2, nums);

        dp[idx][g1][g2] = (int) (ans % MOD);
        return dp[idx][g1][g2];
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}