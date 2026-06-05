import java.util.*;

class Solution {

    static class Pair {
        long ways;
        long waviness;

        Pair(long ways, long waviness) {
            this.ways = ways;
            this.waviness = waviness;
        }
    }

    private String num;
    private Pair[][][][][] memo;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        num = String.valueOf(x);

        memo = new Pair[num.length()][11][11][2][2];

        Pair ans = dfs(0, 10, 10, 1, 0);
        return ans.waviness;
    }

    private Pair dfs(int pos, int prev2, int prev1,
                     int tight, int started) {

        if (pos == num.length()) {
            return new Pair(1, 0);
        }

        if (memo[pos][prev2][prev1][tight][started] != null) {
            return memo[pos][prev2][prev1][tight][started];
        }

        int limit = (tight == 1) ? num.charAt(pos) - '0' : 9;

        long totalWays = 0;
        long totalWaviness = 0;

        for (int digit = 0; digit <= limit; digit++) {

            int newTight =
                    (tight == 1 && digit == limit) ? 1 : 0;

            if (started == 0 && digit == 0) {

                Pair next =
                        dfs(pos + 1, 10, 10, newTight, 0);

                totalWays += next.ways;
                totalWaviness += next.waviness;

            } else {

                int newStarted = 1;

                long add = 0;

                if (prev2 != 10 && prev1 != 10) {

                    if ((prev1 > prev2 && prev1 > digit) ||
                        (prev1 < prev2 && prev1 < digit)) {
                        add = 1;
                    }
                }

                Pair next =
                        dfs(pos + 1, prev1, digit,
                                newTight, newStarted);

                totalWays += next.ways;

                totalWaviness +=
                        next.waviness +
                        add * next.ways;
            }
        }

        return memo[pos][prev2][prev1][tight][started]
                = new Pair(totalWays, totalWaviness);
    }
}