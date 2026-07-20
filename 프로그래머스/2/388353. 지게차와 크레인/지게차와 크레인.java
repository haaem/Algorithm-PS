import java.util.*;

class Solution {
    int n, m;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0 , 0, -1, 1};
    char[][] map;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        map = new char[n + 2][m + 2];
        
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], '.');
        }
        
        for (int i = 0; i < n; i++) {
            String s = storage[i];
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = s.charAt(j);
            }
        }
        
        for (int a = 0; a < requests.length; a++) {
            char target = requests[a].charAt(0);
            if (requests[a].length() == 1) { // 지게차
                find(target);
            } else { // 크레인
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (map[i][j] == target)
                            map[i][j] = '.';
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '.')
                    answer++;
            }
        }
        return answer;
    }
    
    void find(char target) {
        ArrayList<int[]> arr = new ArrayList();
        boolean[][] visited = new boolean[n + 2][m + 2];
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= n + 2 || nx >= m + 2 || visited[ny][nx])
                    continue;
                
                if (map[ny][nx] == '.') {
                    q.offer(new int[] {ny, nx});
                    visited[ny][nx] = true;
                } else if (map[ny][nx] == target) {
                    arr.add(new int[] {ny, nx});
                }
            }
        }
        remove(arr);
    }
    
    void remove(List<int[]> arr) {
        for (int[] a : arr)
            map[a[0]][a[1]] = '.';
    }
}