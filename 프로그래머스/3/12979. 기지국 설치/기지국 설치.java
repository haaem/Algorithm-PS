class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 0;
        int len = 2 * w + 1;
        
        for (int st : stations) {
            int end = st - w - 1;
            answer += Math.ceil(((double) end - start) / len);
            start = st + w;
        }
        answer += Math.ceil(((double) n - start) / len); 

        return answer;
    }
}