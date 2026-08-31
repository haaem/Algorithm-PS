class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for (int i = 1; i <= r2; i++) {
            long y2 = (long) Math.floor(Math.sqrt((long) r2 * r2 - (long) i * i));
            long y1 = (long) Math.ceil(Math.sqrt((long) r1 * r1 - (long) i * i));
            
            answer += y2 - y1 + 1;
        }
        
        return answer * 4;
    }
}