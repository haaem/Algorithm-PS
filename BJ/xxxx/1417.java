import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ1417 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int dasom = -1;
		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				int c = Integer.parseInt(br.readLine());
				dasom = c;
				pq.add(new Node(i, c));
			} else
				pq.add(new Node(i, Integer.parseInt(br.readLine())));
		}
		int min = 0;
		while (pq.peek().num != 1 && pq.peek().count >= dasom) {
			Node node = pq.poll();
			pq.add(new Node(node.num, node.count - 1));
			dasom++;
			min++;
		}
		System.out.println(min);
	}

	private static class Node implements Comparable<Node> {
		int num, count;

		public Node(int num, int count) {
			this.num = num;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			if (o.count == this.count)
				return o.num - this.num;
			return o.count - this.count;
		}
	}
}
