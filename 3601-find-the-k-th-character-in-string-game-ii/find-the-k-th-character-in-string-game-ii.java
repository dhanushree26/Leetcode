class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        // Compute lengths with capping
        long[] lengths = new long[n + 1];
        lengths[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (lengths[i - 1] <= Long.MAX_VALUE / 2) {
                lengths[i] = lengths[i - 1] * 2;
            } else {
                lengths[i] = Long.MAX_VALUE; // cap to avoid overflow
            }
        }
        return helper(operations, n - 1, k, 0L, lengths);
    }
    
    public char helper(int[] ops, int i, long k, long cnt, long[] lengths) {
    if (i < 0) {
        return (char) ('a' + (cnt % 26));
    }
    long half = lengths[i + 1] / 2;
    if (k > half) {
        k -= half;
        if (ops[i] == 1) {
            cnt++;
        }
    }
    return helper(ops, i - 1, k, cnt, lengths);
    }
}
