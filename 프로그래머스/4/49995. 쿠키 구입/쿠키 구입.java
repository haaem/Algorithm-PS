class Solution {
    public int solution(int[] cookie) {
        int n = cookie.length;
        int[] sum = new int[n + 1]; // 누적합
        
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + cookie[i];
        }
        
        int max = 0;
        for (int m = 1; m < n; m++) {
            int l = m;
            int r = m + 1;
            
            while (1 <= l && r <= n) {
                int ls = sum[m] - sum[l - 1];
                int rs = sum[r] - sum[m];
                
                if (ls == rs) {
                    max = Math.max(max, ls);
                    l--;
                    r++;
                } else if (ls < rs) {
                    l--;
                } else {
                    r++;
                }
            }
        }

        return max;
    }
}