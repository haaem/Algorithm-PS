import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] price = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(price[i], Integer.MAX_VALUE);
        }
        
        for (int i = 1; i <= n; i++) {
            price[i][i] = 0;
        }
        for (int i = 0; i < fares.length; i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            
            price[c][d] = f;
            price[d][c] = f;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (price[i][k] == Integer.MAX_VALUE || price[k][j] == Integer.MAX_VALUE)
                        continue;
                    price[i][j] = Math.min(price[i][j], price[i][k] + price[k][j]);
                }
            }
        }
        
        int answer = price[s][a] + price[s][b];
        
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, price[s][i] + price[i][a] + price[i][b]);
        }
        
        return answer;
    }
}