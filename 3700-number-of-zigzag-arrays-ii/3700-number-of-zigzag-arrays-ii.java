class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 2) {
            return (int)((long)m * (m - 1) % MOD);
        }

        int size = 2 * m;

        long[][] T = new long[size][size];

        // up'[j] = sum down[k], k < j
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < j; k++) {
                T[j][m + k] = 1;
            }
        }

        // down'[j] = sum up[k], k > j
        for (int j = 0; j < m; j++) {
            for (int k = j + 1; k < m; k++) {
                T[m + j][k] = 1;
            }
        }

        long[] base = new long[size];

        // length = 2
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {
                if (a == b) continue;

                if (b > a) {
                    base[b]++;
                } else {
                    base[m + b]++;
                }
            }
        }

        long[][] P = power(T, n - 2);

        long ans = 0;

        for (int i = 0; i < size; i++) {
            long cur = 0;

            for (int j = 0; j < size; j++) {
                cur = (cur + P[i][j] * base[j]) % MOD;
            }

            ans = (ans + cur) % MOD;
        }

        return (int) ans;
    }

    private long[][] power(long[][] A, long exp) {
        int n = A.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, A);
            }

            A = multiply(A, A);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;

        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (A[i][k] == 0) continue;

                long val = A[i][k];

                for (int j = 0; j < n; j++) {

                    if (B[k][j] == 0) continue;

                    C[i][j] = (C[i][j] + val * B[k][j]) % MOD;
                }
            }
        }

        return C;
    }
}