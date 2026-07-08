import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        
        int answer = 0;
        
        while (Math.min(bill[0], bill[1]) > wallet[0] || Math.max(bill[0], bill[1]) > wallet[1]) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }
}