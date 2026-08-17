import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]); // index, time
        int n = food_times.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {i, food_times[i]});
        }
        
        int sum = 0;
        HashSet<Integer> set = new HashSet();
        while (!pq.isEmpty()) {
            int[] min = pq.peek();
            int t = min[1] - sum;
            
            int size = (n - set.size());
            if ((long) t * size <= k) {
                k -= t * size;
                sum += t;
                set.add(min[0]);
                pq.poll();
            } else {
                break;
            }
        }
        
        if (pq.isEmpty()) 
            return -1;
        
        List<int[]> lst = new ArrayList(pq);
        lst.sort((a, b) -> a[0] - b[0]);
        return lst.get((int) (k % lst.size()))[0] + 1;
    }
}