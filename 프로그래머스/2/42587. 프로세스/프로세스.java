import java.util.*;

class Solution {
    Queue<int[]> queue;
    
    public int solution(int[] priorities, int location) {
        queue = new ArrayDeque();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {i, priorities[i]});
        }
        
        int count = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            if (check(now[1])) {
                if (location == now[0])
                    return count;
                count++;
            } else {
                queue.offer(now);
            }
        }
        return -1;
    }
    
    boolean check(int p) {
        for (int[] a : queue) {
            if (p < a[1])
                return false;
        }
        return true;
    }
}