import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        Queue<int[]> queue = new ArrayDeque();
        queue.offer(new int[] {0, 0, 1});
        maps[0][0] = 0;
        
        loop: while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int a = 0; a < 4; a++) {
                int ny = now[0] + dy[a];
                int nx = now[1] + dx[a];
                
                if (ny < 0 || nx < 0 || ny >= n || nx >= m || maps[ny][nx] == 0)
                    continue;
                
                if (ny == n - 1 && nx == m - 1) {
                    answer = now[2] + 1;
                    break loop;
                }
                
                queue.offer(new int[] {ny, nx, now[2] + 1});
                maps[ny][nx] = 0;
            }
        }
        return answer;
    }
}