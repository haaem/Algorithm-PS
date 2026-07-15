import java.util.*;

class Solution {
    int answer;
    
    public int solution(int n) {
        dfs(n, 0);
        return answer;
    }
    
    // cnt로 ++ 갯수 확인
    void dfs(int n, int cnt) {
        if (n < 3 || n < Math.pow(3, cnt / 2))
            return;
        
        if (n == 3 && cnt == 2) {
            answer++;
            return;
        }
        
        if (n > 3) {
            if (n % 3 == 0 && cnt >= 2)
                dfs(n / 3, cnt - 2);
            dfs(n - 1, cnt + 1);
        }
    }
}