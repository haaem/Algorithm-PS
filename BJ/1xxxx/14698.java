import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ14698 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<Long>();
			for (int i = 0; i < N; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			long total = 1;
			while (pq.size() >= 2) {
				long a = pq.poll();
				long b = pq.poll();
				Long c = a * b;
				pq.add(c);
				total = total * (c % 1000000007) % 1000000007;
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}
}
