class Solution {
    public int solution(int[][] board) {
        int[] dy = { -1, -1, 1, 1, -1, 1, 0, 0 };
        int[] dx = { -1, 1, -1, 1, 0, 0, -1, 1 };
        
        int n = board.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int a = 0; a < 8; a++) {
                        int y = i + dy[a];
                        int x = j + dx[a];
                        
                        if (y < 0 || x < 0 || y >= n || x >= n || board[y][x] == 1) 
                             continue;
                        
                        board[y][x] = -1;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0)
                    answer++;
            }
        }
        
        return answer;
    }
}