import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ14235 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 0) {
				if (pq.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				for (int j = 0; j < a; j++) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}

	}
}
