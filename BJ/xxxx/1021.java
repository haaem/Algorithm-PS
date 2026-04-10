import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1021 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}
		int[] seq = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for (int i = 0; i < M; i++) {
			int target = deque.indexOf(seq[i]);
			int mid;
			if (deque.size() % 2 == 0)
				mid = deque.size() / 2 - 1;
			else
				mid = deque.size() / 2;
			if (target <= mid) {
				for (int j = 0; j < target; j++) {
					int temp = deque.pollFirst();
					deque.offerLast(temp);
					count++;
				}
			} else {
				for (int j = 0; j < deque.size() - target; j++) {
					int temp = deque.pollLast();
					deque.offerFirst(temp);
					count++;
				}
			}
			deque.pollFirst();
		}
		System.out.println(count);
	}
}
