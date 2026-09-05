import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList();
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a].remove((Integer) b);
            graph[b].remove((Integer) a);
            
            Queue<Integer> q = new ArrayDeque();
            boolean[] visited = new boolean[n + 1];
            q.offer(1);
            int cnt = 1;
            visited[1] = true;
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int t : graph[now]) {
                    if (!visited[t]) {
                        visited[t] = true;
                        q.offer(t);
                        cnt++;
                    }
                }
            }
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        return answer;
    }
}