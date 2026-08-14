public class Solution {
    int[][] land;
    int N, P, Q;
    
    public long solution(int[][] land, int P, int Q) {
        this.N = land.length;
        this.land = land;
        this.P = P;
        this.Q = Q;
        long start = land[0][0];
        long end = land[0][0];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                start = Math.min(start, land[i][j]);
                end = Math.max(end, land[i][j]);
            }
        }
        
        while (start < end) {
            long mid = (start + end) / 2;
            
            if (calculate(mid) < calculate(mid + 1))
                end = mid;
            else 
                start = mid + 1;
            
        }
        
        return calculate(start);
    }
    
    long calculate(long x) {
        long c = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (land[i][j] > x) {
                    c += ((long) land[i][j] - x) * Q;
                } else {
                    c += ((long) x - land[i][j]) * P;
                }
            }
        }
        
        return c;
    }
}