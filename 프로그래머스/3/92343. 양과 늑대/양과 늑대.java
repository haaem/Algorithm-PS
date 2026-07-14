import java.util.*;

class Solution {
    ArrayList<Integer>[] e;
    int[] info;
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        e = new ArrayList[n];
        this.info = info;
        
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList();
        }
        
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            e[edge[0]].add(edge[1]);
        }
        
        ArrayList<Integer> cur = new ArrayList();
        cur.add(0);
        dfs(0, 0, cur);
        
        return answer;
    }
    
    void dfs(int sheep, int wolf, ArrayList<Integer> cur) {
        answer = Math.max(sheep, answer);
        
        for (int a : cur) {
            int ns = info[a] == 0 ? sheep + 1 : sheep;
            int nw = info[a] == 0 ? wolf : wolf + 1;

            if (ns <= nw)
                continue;
            
            ArrayList<Integer> next = new ArrayList(cur);
            next.remove(Integer.valueOf(a));
            next.addAll(e[a]);
            
            dfs(ns, nw, next);
        }
    }
}