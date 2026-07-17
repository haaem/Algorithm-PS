import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        
        for (int len = 1; len < n; len++) {
            for (int a = 0; a < n; a++) {
                int b = a + len;
                
                if (b >= n) break;
                
                dp[a][b] = Integer.MAX_VALUE;
                
                for (int k = a; k < b; k++) {
                    dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k + 1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}