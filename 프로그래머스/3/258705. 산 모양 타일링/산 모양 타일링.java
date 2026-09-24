class Solution {
    public int solution(int n, int[] tops) {
        int MOD = 10007;
        int[] a = new int[n];
        int[] b = new int[n];
        
        a[0] = 1;
        if (tops[0] == 1) b[0] = 3;
        else b[0] = 2;
        
        for (int i = 1; i < n; i++) {
            if (tops[i] == 1) {
                a[i] = (a[i - 1] + b[i - 1]) % MOD;
                b[i] = (a[i - 1] * 2 + b[i - 1] * 3) % MOD;
            } else {
                a[i] = (a[i - 1] + b[i - 1]) % MOD;
                b[i] = (a[i - 1] + b[i - 1] * 2) % MOD;
            }
        }

        return (a[n - 1] + b[n - 1]) % MOD;
    }
}