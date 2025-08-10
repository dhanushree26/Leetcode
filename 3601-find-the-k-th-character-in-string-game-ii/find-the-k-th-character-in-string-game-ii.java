class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] lengths = new long[n + 1];
        lengths[0] = 1;

        // Precompute lengths safely
        for (int i = 1; i <= n; i++) {
            if (lengths[i - 1] <= Long.MAX_VALUE / 2) {
                lengths[i] = lengths[i - 1] * 2;
            } else {
                lengths[i] = Long.MAX_VALUE;
            }
        }

        return helper(operations, n, k, 0, lengths);
    }

    private char helper(int[] operations, int i, long k, long cnt, long[] lengths) {
        if (i == 0) {
            // Base string length = 1
            return (char) ('a' + (cnt % 26));
        }

        long half = lengths[i - 1];
        if (k > half) {
            k -= half;
            if (operations[i - 1] == 1) {
                cnt++;
            }
        }

        return helper(operations, i - 1, k, cnt, lengths);
    }
}
