import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (pq.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(pq.poll().val + "\n");
				}
			} else {
				pq.add(new Node(input));
			}
		}
		System.out.println(sb);
	}
}

class Node implements Comparable<Node> {
	int val;

	public Node(int val) {
		this.val = val;
	}

	@Override
	public int compareTo(Node o) {
		if (Math.abs(this.val) < Math.abs(o.val)) {
			return -1;
		} else if (Math.abs(this.val) > Math.abs(o.val)) {
			return 1;
		}
		if (this.val < o.val) {
			return -1;
		} else {
			return 1;
		}
	}
}