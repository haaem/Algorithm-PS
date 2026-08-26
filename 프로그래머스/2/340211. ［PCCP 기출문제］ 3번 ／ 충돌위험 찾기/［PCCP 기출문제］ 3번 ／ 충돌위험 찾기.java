import java.util.*;

class Solution {
    int n, x, m;
    Queue<int[]>[] r;
    int[][] points, routes;
    
    public int solution(int[][] points, int[][] routes) {
        n = points.length;
        x = routes.length;
        m = routes[0].length;
        this.points = points;
        this.routes = routes;
        
        findRoute();
        return count();
    }
    
    int count() {
        int answer = 0;
        while (x > 0) {
            HashMap<String, Integer> map = new HashMap();
            for (int i = 0; i < r.length; i++) {
                if (!r[i].isEmpty()) {
                    int[] now = r[i].poll();
                    String s = now[0] + "-" + now[1];
                    map.putIfAbsent(s, 0);
                    map.put(s, map.get(s) + 1);
                    
                    if (r[i].isEmpty())
                        x--;
                }
            }
            
            for (String k : map.keySet()) {
                if (map.get(k) > 1)
                    answer++;
            }
        }
        
        return answer;
    }
    
    void findRoute() {
        r = new Queue[x];
        for (int i = 0; i < x; i++) {
            r[i] = new ArrayDeque<int[]>();
            int start = routes[i][0];
            int y = points[start - 1][0];
            int x = points[start - 1][1];
            r[i].offer(new int[] {y, x});
            
            for (int j = 1; j < m; j++) {
                int next = routes[i][j];
                int ny = points[next - 1][0];
                int nx = points[next - 1][1];
                
                while (ny != y) {
                    if (ny > y)
                        y++;
                    else
                        y--;
                    r[i].offer(new int[] {y, x});
                }
                
                while (nx != x) {
                    if (nx > x)
                        x++;
                    else
                        x--;
                    r[i].offer(new int[] {y, x});
                }
            }
        }
    }
}