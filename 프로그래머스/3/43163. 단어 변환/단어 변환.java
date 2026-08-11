import java.util.*;

class Solution {
    String target;
    String[] words;
    boolean[] visited;
    int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        visited = new boolean[words.length];
        dfs(begin, 0);
        
        if (answer == Integer.MAX_VALUE)
            return 0;
        return answer;
    }
    
    void dfs(String word, int count) {
        if (word.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && check(word, words[i])) {
                visited[i] = true;
                dfs(words[i], count + 1);
                visited[i] = false;
            }
        }
    }
    
    boolean check(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                cnt++;
        }
        
        if (cnt == 1)
            return true;
        return false;
    }
}