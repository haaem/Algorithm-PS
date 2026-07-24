class Solution {
    int[][] cost, hint;
    int[] has;
    int n, k, total;
    
    public int solution(int[][] cost, int[][] hint) {
        n = cost.length;
        k = hint[0].length - 1;
        System.out.println(k);
        
        has = new int[n + 1];
        this.cost = cost;
        this.hint = hint;
        total = Integer.MAX_VALUE;
        
        backtracking(1, 0);
        return total;
    }
    
    void backtracking(int i, int c) {
        if (i == n) {
            total = Math.min(total, c + cost[n - 1][Math.min(has[i], n - 1)]);
            return;
        }
        for (int a = 1; a <= k; a++) {
            has[hint[i - 1][a]]++;
        }
        backtracking(i + 1, c + cost[i - 1][Math.min(has[i], n - 1)] + hint[i - 1][0]);
        for (int a = 1; a <= k; a++) {
            has[hint[i - 1][a]]--;
        }
        backtracking(i + 1, c + cost[i - 1][Math.min(has[i], n - 1)]);
    }
}