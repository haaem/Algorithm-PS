import java.util.*;

class Solution {
    int n;
    int[] num;
    char[] op;
    
    public int solution(String arr[]) {
        n = arr.length / 2;
        num = new int[n + 1];
        op = new char[n];
        int INF = (int) 1e9;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num[i / 2] = Integer.parseInt(arr[i]);
            } else {
                op[i / 2] = arr[i].charAt(0);
            }
        }
        
        int[][] minDp = new int[n + 1][n + 1];
        int[][] maxDp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(minDp[i], INF);
            Arrays.fill(maxDp[i], -INF);
        }
        
        for (int i = 0; i < n + 1; i++) {
            minDp[i][i] = maxDp[i][i] = num[i];
        }
        
        for (int size = 1; size <= n; size++) {
            for (int s = 0; s <= n - size; s++) {
                int e = s + size;
                for (int k = s; k < e; k++) {
                    if (op[k] == '+') {
                        minDp[s][e] = Math.min(minDp[s][e], minDp[s][k] + minDp[k + 1][e]);
                        maxDp[s][e] = Math.max(maxDp[s][e], maxDp[s][k] + maxDp[k + 1][e]);
                    } else {
                        minDp[s][e] = Math.min(minDp[s][e], minDp[s][k] - maxDp[k + 1][e]);
                        maxDp[s][e] = Math.max(maxDp[s][e], maxDp[s][k] - minDp[k + 1][e]);
                    }
                }
            }
        }
        
        return maxDp[0][n];
    }
}