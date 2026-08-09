import java.util.*;

class Solution {
    HashSet<Integer> visited;
    HashMap<Integer, ArrayList<Integer>> map;
    HashMap<Integer, Integer> count;
    int yellow, red;
    
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
        count = new HashMap();
        map = new HashMap();
        visited = new HashSet();
        
        for (int i = 0; i < nodes.length; i++) {
            map.put(nodes[i], new ArrayList());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        for (int key : nodes) 
            count.put(key, map.get(key).size());
        
        for (int key : nodes) {
            if (visited.contains(key))
                continue;
            
            yellow = 0;
            red = 0;
            search(key);
            
            if (yellow == 1)
                answer[0]++;
            if (red == 1)
                answer[1]++;
        }
        
        return answer;
    }
    
    void search(int node) {
        if (visited.contains(node))
            return;
        
        visited.add(node);
        if (count.get(node) % 2 == node % 2)
            yellow++;
        else
            red++;
        
        for (int a : map.get(node))
            search(a);
    }
}