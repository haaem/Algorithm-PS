class Solution {
    public int[] solution(int e, int[] starts) {
        int[] count = new int[e + 1];
        for (int i = 1; i <= e; i++) 
            for (int j = i; j <= e; j += i)
                count[j]++;
        
        int[] dp = new int[e + 1]; // 구간 중 가장 많이 등장한 수
        dp[e] = e;
        for (int i = e - 1; i > 0; i--) {
            if (count[i] >= count[dp[i + 1]])
                dp[i] = i;
            else
                dp[i] = dp[i + 1];
        }
        
        int[] answer = new int[starts.length];
        for (int i = 0; i < starts.length; i++) {
            answer[i] = dp[starts[i]];
        }
        return answer;
    }
}