class Solution {
    static final long MOD = 1_000_000_007L;
    int maxDepth = 0;
    List<Integer>[] graph;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1, -1, 0);

        // answer = 2^(maxDepth - 1) % MOD
        return (int) modPow(2, maxDepth - 1);
    }

    void dfs(int node, int parent, int depth) {
        maxDepth = Math.max(maxDepth, depth);

        for (int next : graph[node]) {
            if (next != parent) {
                dfs(next, node, depth + 1);
            }
        }
    }

    long modPow(long base, int exp) {
        long res = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }
}