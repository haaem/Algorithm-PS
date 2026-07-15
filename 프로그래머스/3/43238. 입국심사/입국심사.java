import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long min = 0;
        long max = (long) times[times.length - 1] * n;
        long answer = max;
        
        while (min <= max) {
            long mid = (min + max) / 2;
            
            long count = 0;
            for (int a : times) {
                count += mid / a;
            }
            
            if (count >= n) {
                answer = Math.min(answer, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }
}