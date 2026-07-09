class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] add = new int[24];
        int server = 0;
        
        for (int i = 0; i < 24; i++) {
            if (i >= k) {
                server -= add[i - k];
            }
                
            if (players[i] / m > server) {
                int more = players[i] / m - server;
                add[i] = more;
                answer += more;
                server += more;
            }
        }
        
        return answer;
    }
}