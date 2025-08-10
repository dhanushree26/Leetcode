class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] len = new long[n + 1];
        len[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (len[i - 1] <= Long.MAX_VALUE / 2) {
                len[i] = len[i - 1] * 2;
            } else {
                len[i] = Long.MAX_VALUE;
            }
        }
        return helper(operations, n - 1, k, 0, len);
    }
    public char helper(int[] ops, int i, long k, long cnt, long[] len) {
        if (i < 0) {
            return (char) ('a' + (cnt % 26));
        }
        long half = len[i + 1] / 2;
        if (k > half) {
            k = k - half;
            if (ops[i] == 1) {
                cnt++;
            }
        }
        return helper(ops, i - 1, k, cnt, len);
    }
}