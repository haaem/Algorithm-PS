import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int l = 0, s = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];
            Arrays.sort(size);
            s = Math.max(size[0], s);
            l = Math.max(size[1], l);
        }
        
        return s * l;
    }
}