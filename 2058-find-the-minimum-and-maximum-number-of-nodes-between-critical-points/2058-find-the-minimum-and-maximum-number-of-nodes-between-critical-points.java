class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        int first = -1;
        int last = -1;

        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {

            int nextValue = curr.next.val;

            // Check whether curr is a critical point
            if ((curr.val > prev.val && curr.val > nextValue) ||
                (curr.val < prev.val && curr.val < nextValue)) {

                if (first == -1) {
                    // First critical point
                    first = index;
                } else {
                    // Distance from previous critical point
                    minDistance = Math.min(minDistance, index - last);
                }

                last = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than 2 critical points
        if (first == -1 || first == last) {
            return ans;
        }

        ans[0] = minDistance;
        ans[1] = last - first;

        return ans;
    }
}