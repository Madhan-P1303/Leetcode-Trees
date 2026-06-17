class Solution {
    public char processStr(String s, long k) {

        long len = 0;

        // Forward pass: compute final length
        for (char ch : s.toCharArray()) {

            if (ch >= 'a' && ch <= 'z') {
                len++;
            }
            else if (ch == '#') {
                len *= 2;
            }
            else if (ch == '*') {
                if (len > 0) len--;
            }
            // '%' does not change length
        }

        if (k >= len) return '.';

        // Backward pass
        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {

                len--;

                if (k == len) {
                    return ch;
                }
            }
            else if (ch == '#') {

                long prev = len / 2;

                if (k >= prev) {
                    k -= prev;
                }

                len = prev;
            }
            else if (ch == '*') {

                len++;
            }
            else if (ch == '%') {

                k = len - 1 - k;
            }
        }

        return '.';
    }
}