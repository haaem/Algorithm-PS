import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		ArrayList<Node>[] map = new ArrayList[V+1];
		for (int i=1; i<=V; i++) {
			map[i] = new ArrayList<Node>();
		}
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			for (Node n : map[node.next]) {
				if (dist[n.next] > dist[node.next]+n.w) {
					dist[n.next] = dist[node.next]+n.w;
					pq.add(new Node(n.next, dist[n.next]));
				}
			}
		}
		
		for (int i=1; i<=V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				bw.append("INF\n");
			} else {
				bw.append(dist[i]+"\n");
			}
		}
		bw.flush(); bw.close();
	}
}

class Node implements Comparable<Node>{
	int next;
	int w;
	
	public Node(int next, int w) {
		this.next = next;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}