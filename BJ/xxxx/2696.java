import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2696 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			int M = Integer.parseInt(br.readLine());
			sb.append(M / 2 + 1).append("\n");
			// max heap보다 큰 값들
			PriorityQueue<Integer> min = new PriorityQueue<Integer>();
			// min heap보다 작은 값들
			PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				if (i % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}

				if (min.size() == max.size())
					max.offer(Integer.parseInt(st.nextToken()));
				else
					min.offer(Integer.parseInt(st.nextToken()));

				if (!min.isEmpty() && min.peek() < max.peek()) {
					int a = min.poll();
					int b = max.poll();
					min.offer(b);
					max.offer(a);
				}

				if (i % 2 == 0) {
					sb.append(max.peek()).append(" ");
					cnt++;
				}
				if (cnt == 10 || i == M - 1) {
					cnt = 0;
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
