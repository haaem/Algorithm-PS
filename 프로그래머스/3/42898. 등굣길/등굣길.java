class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] map = new int[n + 1][m + 1];
        
        for (int i = 0; i < puddles.length; i++) {
            int[] p = puddles[i];
            map[p[1]][p[0]] = -1;
        }
        
        for (int i = 1; i <= m; i++) {
            if (map[1][i] == -1)
                break;
            map[1][i] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            if (map[i][1] == -1)
                break;
            map[i][1] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (map[i][j] == -1)
                    continue;
                
                if (map[i - 1][j] != -1 && map[i][j - 1] != -1)
                    map[i][j] = (map[i - 1][j] + map[i][j - 1]) % MOD;
                else if (map[i - 1][j] == -1)
                    map[i][j] = map[i][j - 1];
                else if (map[i][j - 1] == -1) {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        return map[n][m];
    }
}