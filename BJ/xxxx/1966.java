import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1966 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			LinkedList<Node> queue = new LinkedList<Node>();

			for (int i = 0; i < N; i++) {
				queue.offer(new Node(Integer.parseInt(st.nextToken()), i));
			}

			int count = 0;

			while (!queue.isEmpty()) {
				Node temp = queue.poll();
				boolean isMax = true;

				for (int i = 0; i < queue.size(); i++) {
					if (temp.pri < queue.get(i).pri) {
						queue.offer(temp);
						for (int j = 0; j < i; j++) {
							queue.offer(queue.poll());
						}
						isMax = false;
						break;
					}
				}

				if (!isMax)
					continue;

				count++;
				if (temp.order == M)
					break;
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}

class Node {
	int pri;
	int order;

	public Node(int pri, int order) {
		this.pri = pri;
		this.order = order;
	}
}