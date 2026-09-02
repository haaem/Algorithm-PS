import java.util.*;

class Solution {
    int[] di = {-1, 1, 0, 0};
    int[] dj = {0, 0, -1, 1};
    boolean[][] visited;
    int[][] land;
    int n, m;
    HashSet<Integer>[] num;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        this.land = land;
        
        ArrayList<Integer> arr = new ArrayList();
        num = new HashSet[m];
        for (int i = 0; i < m; i++)
            num[i] = new HashSet();
        
        int a = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    arr.add(bfs(i, j, a++));
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int t : num[i]) {
                sum += arr.get(t);
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    int bfs(int i, int j, int t) {
        int count = 1;
        Queue<int[]> q = new ArrayDeque();
        q.offer(new int[] {i, j});
        visited[i][j] = true;
        num[j].add(t);
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            
            for (int a = 0; a < 4; a++) {
                int ni = now[0] + di[a];
                int nj = now[1] + dj[a];
                
                if (ni < 0 || nj < 0 || ni >= n || nj >= m || visited[ni][nj] || land[ni][nj] == 0)
                    continue;
                
                num[nj].add(t);
                visited[ni][nj] = true;
                q.offer(new int[] {ni, nj});
                count++;
            }
        }
        
        return count;
    }
}