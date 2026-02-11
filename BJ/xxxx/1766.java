import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1766 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> solve = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= N; i++) {
			solve.add(new ArrayList<Integer>());
		}

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int[] count = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			solve.get(first).add(next);
			count[next]++;
		}

		for (int i = 1; i <= N; i++) {
			if (count[i] == 0)
				pq.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int a = pq.poll();
			sb.append(a).append(" ");

			for (int n : solve.get(a)) {
				count[n]--;
				if (count[n] == 0)
					pq.offer(n);
			}
		}
		System.out.println(sb);
	}
}
