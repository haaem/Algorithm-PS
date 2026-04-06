import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5567 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] arr = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		boolean[] invited = new boolean[n + 1];
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}

		Queue<Friend> queue = new ArrayDeque<Friend>();
		invited[1] = true;
		queue.add(new Friend(0, 1));
		int count = 0;
		while (!queue.isEmpty()) {
			Friend now = queue.poll();
			if (now.depth >= 2)
				continue;
			for (int a : arr[now.to]) {
				if (!invited[a]) {
					invited[a] = true;
					count++;
					queue.offer(new Friend(now.depth + 1, a));
				}
			}
		}
		System.out.println(count);
	}

	static class Friend {
		int depth;
		int to;

		Friend(int d, int t) {
			this.depth = d;
			this.to = t;

		}
	}
}
