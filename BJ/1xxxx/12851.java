import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ12851 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<int[]> queue = new ArrayDeque<int[]>();
		int[] count = new int[100001];
		Arrays.fill(count, Integer.MAX_VALUE);
		queue.offer(new int[] { N, 0 });
		count[N] = 0;
		int min = Integer.MAX_VALUE;
		int method = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int loc = now[0];
			int sec = now[1];
			if (loc == K) {
				if (min > sec) {
					min = sec;
					method = 1;
				} else if (min == sec) {
					method++;
				}
			}
			if (sec >= min)
				continue;
			if (loc + 1 <= 100000 && count[loc + 1] >= sec + 1) {
				count[loc + 1] = sec + 1;
				queue.offer(new int[] { loc + 1, sec + 1 });
			}
			if (loc - 1 >= 0 && count[loc - 1] >= sec + 1) {
				count[loc - 1] = sec + 1;
				queue.offer(new int[] { loc - 1, sec + 1 });
			}
			if (loc * 2 <= 100000 && count[loc * 2] >= sec + 1) {
				count[loc * 2] = sec + 1;
				queue.offer(new int[] { loc * 2, sec + 1 });
			}
		}
		System.out.println(min);
		System.out.println(method);
	}
}
