import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        Arrays.sort(bans, (a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();
            return a.compareTo(b);
        });
        for (int i = 0; i < bans.length; i++) {
            long t = 0;
            String s = bans[i];
            for (int j = 0; j < s.length(); j++) {
                t = t * 26 + (s.charAt(j) - 'a' + 1);
            }
            
            if (t <= n)
                n++;
        }
        
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            char c = (char) ((int) (n % 26) + 'a');
            sb.insert(0, c);
            n /= 26;
        }
        
        return sb.toString();
    }
}