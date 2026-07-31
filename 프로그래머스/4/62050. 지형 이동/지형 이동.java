import java.util.*;

class Solution {
    public int solution(int[][] land, int height) {
        int N = land.length;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        Queue<int[]> queue = new ArrayDeque();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[N][N];
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;
        int answer = 0;
        
        while (true) {
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int y = now[0];
                int x = now[1];
                
                for (int a = 0; a < 4; a++) {
                    int ny = y + dy[a];
                    int nx = x + dx[a];
                    
                    if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx])
                        continue;
                    
                    int next = Math.abs(land[ny][nx] - land[y][x]);
                    if (next > height) {
                        pq.offer(new int[] {ny, nx, next});
                    } else {
                        queue.offer(new int[] {ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
            
            while (!pq.isEmpty() && visited[pq.peek()[0]][pq.peek()[1]])
                pq.poll();
            
            if (pq.isEmpty())
                break;
            
            int[] next = pq.poll();
            answer += next[2];
            
            queue.offer(new int[] {next[0], next[1]});
            visited[next[0]][next[1]] = true;
        }
        
        return answer;
    }
}