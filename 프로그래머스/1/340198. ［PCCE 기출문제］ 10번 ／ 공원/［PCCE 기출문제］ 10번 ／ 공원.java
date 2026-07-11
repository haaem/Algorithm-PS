import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int h = park.length;
        int w = park[0].length;
        
        int[][] sum = new int[h + 1][w + 1];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                int add = park[i - 1][j - 1].equals("-1") ? 0 : 1;
                sum[i][j] = add + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        
        Arrays.sort(mats);
        
        for (int a = mats.length - 1; a >= 0; a--) {
            int mat = mats[a];
            
            if (mat > h || mat > w)
                continue;
            for (int i = 0; i <= h - mat; i++) {
                for (int j = 0; j <= w - mat; j++) {
                    if (sum[i + mat][j + mat] - sum[i][j + mat] - sum[i + mat][j] + sum[i][j] == 0)
                        return mat;
                }
            }
        }
        
        return -1;
    }
}