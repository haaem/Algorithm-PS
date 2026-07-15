import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] e = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            e[i] = new ArrayList();
        }
        
        for (int[] t : edge) {
            e[t[0]].add(t[1]);
            e[t[1]].add(t[0]);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue();
        
        dist[1] = 0;
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            for (int i : e[now.next]) {
                if (dist[i] == Integer.MAX_VALUE) {
                    dist[i] = now.d + 1;
                    pq.offer(new Node(i, dist[i]));
                } else if (now.d + 1 < dist[i]) {
                    dist[i] = now.d + 1;
                    pq.offer(new Node(i, dist[i]));
                }
            }
        }
        
        int max = 0;
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        for (int a : dist) {
            if (a == max)
                answer++;
        }
        
        return answer;
    }
}

class Node implements Comparable<Node> {
    int next, d;
    
    Node(int next, int d) {
        this.next = next;
        this.d = d;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.d - o.d;
    }
}