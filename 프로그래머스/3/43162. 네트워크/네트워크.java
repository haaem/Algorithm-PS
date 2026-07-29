import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }   
            }
        }
        
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }
        return set.size();
    }
    
    int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    
    void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        
        if (B > A) {
            parent[B] = A;
        } else {
            parent[A] = B;
        }
    }
}