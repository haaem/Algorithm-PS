import java.util.*;

class Solution {
    HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap();
    boolean[] visited;
    int k, n;
    Queue<Integer> queue = new ArrayDeque();
    
    public int solution(int n, int infection, int[][] edges, int k) {
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int x = edge[0];
            int y = edge[1];
            int z = edge[2];
            
            map.putIfAbsent(x, new HashMap<Integer, Integer>());
            map.get(x).put(y, z);
            map.putIfAbsent(y, new HashMap<Integer, Integer>());
            map.get(y).put(x, z);
        }
        
        this.k = k;
        this.n = n;
        visited = new boolean[n + 1];
        
        visited[infection] = true;
        queue.offer(infection);
        
        return backtracking(0, 1);
    }
    
    int backtracking(int count, int total) {
        if (count == k)
            return total;
        if (total == n)
            return n;
        
        int best = total;
        
        for (int a : new int[] {1, 2, 3}) {
            List<Integer> lst = infect(a);
            best = Math.max(best, backtracking(count + 1, total + lst.size()));
            for (int b : lst)
                visited[b] = false;
        }
        
        return best;
    }
    
    List<Integer> infect(int type) {
        ArrayList<Integer> arr = new ArrayList();
        Queue<Integer> q = new ArrayDeque();
        
        for (int i = 1; i <= n; i++) {
            if (visited[i])
                q.offer(i);
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int a : map.get(now).keySet()) {
                if (map.get(now).get(a) == type && !visited[a]) {
                    arr.add(a);
                    visited[a] = true;
                    q.offer(a);
                }
            }
        }
        
        return arr;
    }
}