class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int sum = sequence[0];
        int s = 0, e = 0, len = 1_000_000;
        int[] answer = new int[] {0, 0};
        
        while (true) {
            if (sum == k) {
                if (e - s < len) {
                    len = e - s;
                    answer = new int[] {s, e};
                }
                sum -= sequence[s++];
                if (s > e) {
                    if (e + 1 == n)
                        break;
                    sum += sequence[++e];
                }
                
            } else if (sum < k) {
                e++;
                if (e == n)
                    break;
                sum += sequence[e];
            } else {
                sum -= sequence[s++];
            }
        }
        
        return answer;
    }
}