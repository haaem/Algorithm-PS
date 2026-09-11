import java.util.*;

class Solution {
    boolean[] visited;
    String[][] tickets;
    String[] answer;
    int n;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        n = tickets.length;
        visited = new boolean[n];
        answer = new String[n + 1];
        Arrays.sort(this.tickets, (a, b) -> {
            if (a[0].equals(b[0]))
                return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        answer[0] = "ICN";
        dfs(0, "ICN");
        
        return answer;
    }
    
    boolean dfs(int depth, String now) {
        if (depth == n)
            return true;
        for (int i = 0; i < n; i++) {
            if (now.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                answer[depth + 1] = tickets[i][1];
                if (dfs(depth + 1, tickets[i][1]))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
}