import java.util.*;

class Solution {
    boolean[] visited;
    String s;
    int n;
    String[] arr;
    HashSet<Integer> set;
    
    public int solution(String numbers) {
        set = new HashSet();
        s = numbers;
        n = numbers.length();
        arr = new String[n];
        visited = new boolean[n];
        makeNumber(0);
        
        return set.size();
    }
    
    void makeNumber(int depth) {
        if (depth == n) return;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = s.substring(i, i + 1);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j <= depth; j++) {
                    sb.append(arr[j]);
                }
                int target = Integer.parseInt(sb.toString());
                if (isPrime(target))
                    set.add(target);
                makeNumber(depth + 1);
                visited[i] = false;
            }
        }
    }
    
    boolean isPrime(int n) {
        if (n <= 1) return false;
        System.out.println(n);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}