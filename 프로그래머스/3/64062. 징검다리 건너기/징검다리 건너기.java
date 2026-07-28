class Solution {
    public int solution(int[] stones, int k) {
        int s = 1;
        int e = 200_000_000;
        
        loop: while (s <= e) {
            int mid = (s + e) / 2;
            
            int c = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] > mid)
                    c = 0;
                else
                    c++;
                
                if (c >= k) {
                    e = mid - 1;
                    continue loop;
                }
            }
            s = mid + 1;
        }
        
        return s;
    }
}