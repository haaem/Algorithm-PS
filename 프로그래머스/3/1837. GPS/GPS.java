import java.util.*;

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int INF = 1_000_000;
        boolean[][] edge = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            int[] e = edge_list[i];
            edge[e[0]][e[1]] = true;
            edge[e[1]][e[0]] = true;
        }
        
        int[][] dp = new int[k][n + 1];
        
        for (int[] t : dp) 
            Arrays.fill(t, INF);
        
        dp[0][gps_log[0]] = 0;
        
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                // 만약에 i-1초에 j에 있는 게 아예 불가능하면 다음 경로를 확인할 필요가 사라짐
                if (dp[i - 1][j] == INF)
                    continue;
                
                for (int a = 1; a <= n; a++) {
                    if (edge[j][a]) {
                        if (a == gps_log[i])
                            dp[i][a] = Math.min(dp[i - 1][j], dp[i][a]);
                        else
                            dp[i][a] = Math.min(dp[i - 1][j] + 1, dp[i][a]);
                    }
                }
            }
        }
        
        if (dp[k - 1][gps_log[k - 1]] == INF)
            return -1;
        
        return dp[k - 1][gps_log[k - 1]];
    }
}