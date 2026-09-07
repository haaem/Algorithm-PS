import java.util.*;

class Solution {
    int[][] map;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for (int a = y1; a <= y2; a++) {
                for (int b = x1; b <= x2; b++) {
                    if (map[a][b] == 1)
                        continue;
                    
                    if (a == y1 || a == y2 || b == x1 || b == x2)
                        map[a][b] = 2;
                    else
                        map[a][b] = 1;
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque();
        boolean[][] visited = new boolean[101][101];
        q.offer(new int[] {characterY * 2, characterX * 2, 0});
        visited[characterY * 2][characterX * 2] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            if (now[0] == itemY * 2 && now[1] == itemX * 2)
                return now[2] / 2;
            
            for (int a = 0; a < 4; a++) {
                int ny = now[0] + dy[a];
                int nx = now[1] + dx[a];
                
                if (ny < 0 || nx < 0 || ny >= 101 || nx >= 101)
                    continue;
                
                if (map[ny][nx] == 2 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.offer(new int[] {ny, nx, now[2] + 1});
                }
            }
            
        }
        
        return -1;
    }
}