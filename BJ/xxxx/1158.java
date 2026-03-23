import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		int i = 1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (!queue.isEmpty()) {
			if (i % K == 0) {
				sb.append(queue.poll());
				if (queue.size() == 0)
					sb.append(">");
				else
					sb.append(", ");
			} else {
				queue.offer(queue.poll());
			}
			i++;
		}
		System.out.println(sb);
	}
}
