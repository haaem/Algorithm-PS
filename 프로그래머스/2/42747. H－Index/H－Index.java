import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        
        if (citations[0] >= n)
            return n;
        
        int s = 0;
        int e = n;
        int answer = 0;
        
        while (s <= e) {
            int mid = (s + e) / 2;
            
            int count = 0;
            for (int c : citations) {
                if (c >= mid) count++;
            }
            if (count >= mid) {
                answer = Math.max(answer, mid);
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        
        return answer;
    }
}