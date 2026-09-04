class Solution {
    int[][] dungeons;
    int n, k, answer;
    boolean[] visited;
    int[] seq;
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        n = dungeons.length;
        this.k = k;
        visited = new boolean[n];
        seq = new int[n];
        
        backtracking(0);
    
        return answer;
    }
    
    void backtracking(int depth) {
        if (depth == n) {
            answer = Math.max(answer, count());
            return;
        }
        for (int a = 0; a < n; a++) {
            if (!visited[a]) {
                visited[a] = true;
                seq[depth] = a;
                backtracking(depth + 1);
                visited[a] = false;
            }
        }
    }
    
    int count() {
        int t = k;
        for (int i = 0; i < n; i++) {
            int[] a = dungeons[seq[i]];
            if (a[0] <= t)
                t -= a[1];
            else
                return i;
        }
        return n;
    }
}