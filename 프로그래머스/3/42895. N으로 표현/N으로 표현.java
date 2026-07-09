import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        HashSet<Integer>[] dp = new HashSet[9];
        
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet();
        }
        
        dp[1].add(N);
        
        StringBuilder sb = new StringBuilder();
        sb.append(N);
        
        for (int i = 2; i <= 8; i++) {
            sb.append(N);
            dp[i].add(Integer.parseInt(sb.toString()));
            
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0)
                            dp[i].add(a / b);
                    }
                }
            }
            
            if (dp[i].contains(number))
                return i;
        }
        
        return -1;
    }
}