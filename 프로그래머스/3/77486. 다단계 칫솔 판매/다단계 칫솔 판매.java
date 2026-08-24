import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parent = new HashMap();
        HashMap<String, Integer> price = new HashMap();
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            price.put(enroll[i], 0);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String now = seller[i];
            int a = amount[i] * 100;
            
            while (!parent.get(now).equals("-") && a > 0) {
                int up = a / 10;
                price.put(now, price.get(now) + (a - up));
                a = up;
                now = parent.get(now);
            }
            price.put(now, price.get(now) + (a - (a / 10)));
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = price.get(enroll[i]);
        }
        return answer;
    }
}