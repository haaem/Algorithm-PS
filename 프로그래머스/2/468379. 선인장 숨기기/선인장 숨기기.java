import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        
        for (int i = 0; i < drops.length; i++) {
            d[drops[i][0]][drops[i][1]] = i + 1;
        }
        
        int[][] rowMin = new int[m][n - w + 1];
        for (int r = 0; r < m; r++) {
            int[] row = d[r];
            Deque<Integer> dq = new ArrayDeque();
            
            for (int i = 0; i < n; i++) {
                while (!dq.isEmpty() && dq.peekFirst() <= i - w) {
                    dq.pollFirst();
                }
                while (!dq.isEmpty() && row[dq.peekLast()] >= row[i]) {
                    dq.pollLast();
                }
                dq.offerLast(i);
                
                if (i >= w-1) {
                    rowMin[r][i - w + 1] = row[dq.peekFirst()];
                }
            }
        }
        
        int[][] windowMin = new int[m - h + 1][n - w + 1];
        for (int c = 0; c < n - w + 1; c++) {
            Deque<Integer> dq = new ArrayDeque();
            for (int i = 0; i < m; i++) {
                while (!dq.isEmpty() && dq.peekFirst() <= i - h) {
                    dq.pollFirst();
                }
                while (!dq.isEmpty() && rowMin[dq.peekLast()][c] >= rowMin[i][c]) {
                    dq.pollLast();
                }
                dq.offerLast(i);
                
                if (i >= h-1) {
                    windowMin[i - h + 1][c] = rowMin[dq.peekFirst()][c];
                }
            }
        }
        
        int max = -1;
        int bestR = 0, bestC = 0;
        for (int r = 0; r < m - h + 1; r++) {
            for (int c = 0; c < n - w + 1; c++) {
                if (max < windowMin[r][c]) {
                    max = windowMin[r][c];
                    bestR = r;
                    bestC = c;
                }
            }
        }
        
        return new int[]{bestR, bestC};
    }
}