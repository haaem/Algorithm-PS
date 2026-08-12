class Solution {
    public int solution(int n, int[][] results) {
        int[][] arr = new int[n + 1][n + 1];
        
        for (int i = 0; i < results.length; i++) {
            int a = results[i][0];
            int b = results[i][1];
            arr[a][b] = 1;
            arr[b][a] = -1;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][k] == 0 || arr[k][j] == 0)
                        continue;
                    
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    } else if (arr[i][k] == -1 && arr[k][j] == -1) {
                        arr[i][j] = -1;
                        arr[j][i] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    continue;
                if (arr[i][j] == 0)
                    count++;
            }
            if (count == 0) {
                answer++;
            }
        }
        return answer;
    }
}