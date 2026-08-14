import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> count = new HashMap();
        for (int i = 0; i < clothes.length; i++) {
            String s = clothes[i][1];
            count.putIfAbsent(s, 0);
            count.put(s, count.get(s) + 1);
        }
        
        int answer = 1;
        for (String s : count.keySet()) {
            answer *= (count.get(s) + 1);
        }
        return answer - 1;
    }
}