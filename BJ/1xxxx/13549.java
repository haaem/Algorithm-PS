import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13549 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (N == K) {
			System.out.println(0);
			System.exit(0);
		}
		boolean[] visited = new boolean[100001];

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(N, 0));
		int time = 0;
		loop: while (!pq.isEmpty()) {
			Node node = pq.poll();
			int temp = node.next;
			if (visited[temp])
				continue;
			if (temp == K) {
				time = node.sec;
				break loop;
			}
			visited[temp] = true;
			if (temp * 2 <= 100000) {
				pq.add(new Node(temp * 2, node.sec));
			}
			if (node.next > 0) {
				pq.add(new Node(node.next - 1, node.sec + 1));
			}
			if (node.next < 100000) {
				pq.add(new Node(node.next + 1, node.sec + 1));
			}
		}
		System.out.println(time);
	}
}

class Node implements Comparable<Node> {
	int next;
	int sec;

	public Node(int next, int sec) {
		this.next = next;
		this.sec = sec;
	}

	@Override
	public int compareTo(Node o) {
		return this.sec - o.sec;
	}
}