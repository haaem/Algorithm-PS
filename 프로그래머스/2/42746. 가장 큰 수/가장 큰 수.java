import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] num = new String[numbers.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(num, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        StringBuilder sb = new StringBuilder();
        
        for (String s : num) {
            sb.append(s);
        }
        
        String answer = sb.toString();
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}