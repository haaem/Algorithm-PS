import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int len = rocks.length;
        Arrays.sort(rocks);
        
        int s = 1; 
        int e = distance;
        int answer = 0;
        
        loop: while (s <= e) {
            int mid = (s + e) / 2;
            int prev = 0, count = 0;
            
            for (int i = 0; i < rocks.length; i++) {
                int d = rocks[i] - prev;
                if (d >= mid)
                    prev = rocks[i];
                else
                    count++;
            }
            
            if (distance - prev < mid)
                count++;
            
            if (count > n) {
                e = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                s = mid + 1;
            }
        }

        return answer;
    }
}