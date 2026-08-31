import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int answer = 0;
        int x = 0;
        for (int[] t : targets) {
            int s = t[0];
            int e = t[1];
            
            if (x <= s) {
                x = e;
                answer++;
            }
        }
        return answer;
    }
}