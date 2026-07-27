import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        if (n <= cores.length)
            return n;
        
        int s = 0;
        int e = 10000 * n;
        int time = 0;
        int work = 0;
        
        while (s <= e) {
            int mid = (s + e) / 2;
            int count = cores.length;
            for (int i = 0; i < cores.length; i++) {
                count += mid / cores[i];
            }
            if (count >= n) {
                time = mid;
                work = count;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        
        work -= n;
        for (int i = cores.length - 1; i >= 0; i--) {
            if (time % cores[i] == 0) {
                if (work == 0)
                    return i + 1;
                work--;
            }
        }
        
        return 0;
    }
}