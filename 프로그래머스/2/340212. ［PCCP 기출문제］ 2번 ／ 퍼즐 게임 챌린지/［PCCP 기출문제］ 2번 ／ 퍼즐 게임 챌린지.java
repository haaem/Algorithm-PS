class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        
        int s = 1;
        int e = 100_000;
        int answer = e;
        
        loop: while (s <= e) {
            int mid = (s + e) / 2;
            long time = 0;
            for (int i = 0; i < n; i++) {
                if (diffs[i] <= mid)
                    time += times[i];
                else
                    time += ((times[i - 1] + times[i]) * (diffs[i] - mid) + times[i]);
                
                if (time > limit) {
                    s = mid + 1;
                    continue loop;
                }
            }
            answer = Math.min(answer, mid);
            e = mid - 1;
        }

        return answer;
    }
}