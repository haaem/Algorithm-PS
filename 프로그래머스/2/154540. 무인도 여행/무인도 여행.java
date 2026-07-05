import java.io.*;
import java.util.*;

class Solution {
    boolean[][] visited;
    int[][] m;
    int h, w;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    
    public int[] solution(String[] maps) {
        h = maps.length;
        w = maps[0].length();
        visited = new boolean[h][w];
        m = new int[h][w];
        
        for (int i = 0; i < h; i++) {
            String s = maps[i];
            for (int j = 0; j < w; j++) {
                if (s.charAt(j) == 'X') 
                    m[i][j] = -1;
                else
                    m[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && m[i][j] != -1) {
                    pq.offer(bfs(i, j));
                }
            }
        }
        
        int size = pq.size();
        if (size == 0)
            return new int[] { -1 };
        
        int[] answer = new int[size];
        for (int a = 0; a < size; a++) {
            answer[a] = pq.poll();
        }
        return answer;
    }
    
    int bfs(int i, int j) {
        int day = m[i][j];
        visited[i][j] = true;
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[] {i, j});
        
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int y = arr[0];
            int x = arr[1];
            for (int a = 0; a < 4; a++) {
                int ny = y + dy[a];
                int nx = x + dx[a];
                
                if (ny < 0 || nx < 0 || ny >= h || nx >= w || visited[ny][nx] || m[ny][nx] == -1)
                    continue;
                
                visited[ny][nx] = true;
                day += m[ny][nx];
                q.offer(new int[] {ny, nx});
            }
        }
        return day;
    }
}