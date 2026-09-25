import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < skip.length(); i++) 
            set.add(skip.charAt(i));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;
            while (count < index) {
                c++;
                if (c > 'z') c = 'a';
                if (!set.contains(c)) count++;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}