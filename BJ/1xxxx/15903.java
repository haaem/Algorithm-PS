import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ15903 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		int i = 0;
		while (i < m) {
			long x = pq.poll();
			long y = pq.poll();
			pq.add(x + y);
			pq.add(x + y);
			i++;
		}
		long sum = 0;
		while (!pq.isEmpty()) {
			sum += pq.poll();
		}
		System.out.println(sum);
	}
}