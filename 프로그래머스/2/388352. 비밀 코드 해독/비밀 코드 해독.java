import java.util.*;

class Solution {
    int n, m, answer;
    int[][] q;
    int[] ans;
    HashSet<Integer> set = new HashSet();
    
    public int solution(int n, int[][] q, int[] ans) {
        this.m = q.length;
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        backtracking(0, 1);
        
        return answer;
    }
    
    void backtracking(int depth, int a) {
        if (depth == 5) {
            if (check()) 
                answer++;
            return;
        }
        for (int i = a; i <= n; i++) {
            set.add(i);
            backtracking(depth + 1, i + 1);
            set.remove(i);
        }
    }
    
    boolean check() {
        for (int i = 0; i < m; i++) {
            int[] t = q[i];
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (set.contains(t[j]))
                    count++;
            }
            if (count != ans[i])
                return false;
        }
        return true;
    }
}