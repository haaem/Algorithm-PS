import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int MOD = 1_000_000_007;
        Arrays.sort(money);
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int a : money) {
            for (int i = a; i <= n; i++) {
                dp[i] += dp[i - a];
                dp[i] %= MOD;
            } 
        }
        
        return dp[n];
    }
}