import java.util.*;

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;

        // pair nums and cost
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        // sort by nums
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // find weighted median
        long totalCost = 0;
        for (int c : cost) totalCost += c;

        long curr = 0;
        int median = 0;

        for (int i = 0; i < n; i++) {
            curr += arr[i][1];
            if (curr >= (totalCost + 1) / 2) {
                median = arr[i][0];
                break;
            }
        }

        // calculate result
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long)Math.abs(nums[i] - median) * cost[i];
        }

        return ans;
    }
}
