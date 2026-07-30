import java.util.*;

class Solution {
    int[] di = {-1, 1, 0, 0};
    int[] dj = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][] visited = new boolean[n][n][2]; // 왼, 위
        
        Queue<Robot> queue = new ArrayDeque();
        visited[0][0][0] = true;
        queue.offer(new Robot(0, 0, 0, true));
        
        while (!queue.isEmpty()) {
            Robot now = queue.poll();
            int i = now.i;
            int j = now.j;
            int time = now.time;
            boolean hor = now.hor;
            
            if (hor && i == n - 1 && j == n - 2)
                return time;
            if (!hor && i == n - 2 && j == n - 1)
                return time;
            
            if (hor) { // 가로
                // 한 칸씩 이동
                for (int a = 0; a < 2; a++) {
                    int ni = i + di[a];
                    int nj = j + dj[a];
                    
                    if (ni < 0 || ni >= n || visited[ni][nj][0] || board[ni][nj] == 1 || board[ni][nj + 1] == 1)
                        continue;
                    
                    visited[ni][nj][0] = true;
                    queue.offer(new Robot(ni, nj, time + 1, hor));
                }
                
                for (int a = 2; a < 4; a++) {
                    int ni = i + di[a];
                    int nj = j + dj[a];
                    
                    if (nj < 0 || nj >= n - 1 || visited[ni][nj][0] || board[ni][nj] == 1 || board[ni][nj + 1] == 1)
                        continue;
                    
                    visited[ni][nj][0] = true;
                    queue.offer(new Robot(ni, nj, time + 1, hor));
                }
                
                // 회전
                if (i >= 1 && !visited[i - 1][j][1] && board[i - 1][j] == 0 && board[i - 1][j + 1] == 0) {
                    visited[i - 1][j][1] = true;
                    queue.offer(new Robot(i - 1, j, time + 1, !hor));
                }
                
                if (i < n - 1 && !visited[i][j][1] && board[i + 1][j] == 0 && board[i + 1][j + 1] == 0) {
                    visited[i][j][1] = true;
                    queue.offer(new Robot(i, j, time + 1, !hor));
                }
                
                if (i >= 1 && !visited[i - 1][j + 1][1] && board[i - 1][j + 1] == 0 && board[i - 1][j] == 0) {
                    visited[i - 1][j + 1][1] = true;
                    queue.offer(new Robot(i - 1, j + 1, time + 1, !hor));
                }
                
                if (i < n - 1 && !visited[i][j + 1][1] && board[i + 1][j] == 0 && board[i + 1][j + 1] == 0) {
                    visited[i][j + 1][1] = true;
                    queue.offer(new Robot(i, j + 1, time + 1, !hor));
                }
            } else { // 세로
                // 한 칸씩 이동
                for (int a = 0; a < 2; a++) {
                    int ni = i + di[a];
                    int nj = j + dj[a];
                    
                    if (ni < 0 || ni >= n - 1 || visited[ni][nj][1] || board[ni][nj] == 1 || board[ni + 1][nj] == 1)
                        continue;
                    
                    visited[ni][nj][1] = true;
                    queue.offer(new Robot(ni, nj, time + 1, hor));
                }
                
                for (int a = 2; a < 4; a++) {
                    int ni = i + di[a];
                    int nj = j + dj[a];
                    
                    if (nj < 0 || nj >= n || visited[ni][nj][1] || board[ni][nj] == 1 || board[ni + 1][nj] == 1)
                        continue;
                    
                    visited[ni][nj][1] = true;
                    queue.offer(new Robot(ni, nj, time + 1, hor));
                }
                
                // 회전
                if (j >= 1 && !visited[i][j - 1][0] && board[i][j - 1] == 0 && board[i + 1][j - 1] == 0) {
                    visited[i][j - 1][0] = true;
                    queue.offer(new Robot(i, j - 1, time + 1, !hor));
                }
                
                if (j < n - 1 && !visited[i][j][0] && board[i][j + 1] == 0 && board[i + 1][j + 1] == 0) {
                    visited[i][j][0] = true;
                    queue.offer(new Robot(i, j, time + 1, !hor));
                }
                
                if (j >= 1 && !visited[i + 1][j - 1][0] && board[i][j - 1] == 0 && board[i + 1][j - 1] == 0) {
                    visited[i + 1][j - 1][0] = true;
                    queue.offer(new Robot(i + 1, j - 1, time + 1, !hor));
                }
                
                if (j < n - 1 && !visited[i + 1][j][0] && board[i][j + 1] == 0 && board[i + 1][j + 1] == 0) {
                    visited[i + 1][j][0] = true;
                    queue.offer(new Robot(i + 1, j, time + 1, !hor));
                }
            }
        }
        
        return -1;
    }
}

class Robot {
    int i, j, time;
    boolean hor;
    
    Robot(int i, int j, int time, boolean hor) {
        this.i = i;
        this.j = j;
        this.time = time;
        this.hor = hor;
    }
}