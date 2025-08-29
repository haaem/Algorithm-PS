import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2042 {
	static int N, M, K;
	static long[] sumTree;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sumTree = new long[4 * N];
		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(0, N - 1, 1);
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if (a == 1) {
				update(0, N - 1, b - 1, c, 1);
			} else if (a == 2) {
				sb.append(query(0, N - 1, b - 1, (int) c - 1, 1)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void init(int s, int e, int index) {
		if (s == e) {
			sumTree[index] = arr[s];
			return;
		}
		int m = (s + e) / 2;
		init(s, m, 2 * index);
		init(m + 1, e, 2 * index + 1);
		sumTree[index] = sumTree[2 * index] + sumTree[2 * index + 1];
	}

	static long query(int s, int e, int qs, int qe, int index) {
		if (qs <= s && e <= qe) {
			return sumTree[index];
		} else if (e < qs || qe < s) {
			return 0;
		} else {
			int m = (s + e) / 2;
			long a = query(s, m, qs, qe, 2 * index);
			long b = query(m + 1, e, qs, qe, 2 * index + 1);
			return a + b;
		}
	}

	static void update(int s, int e, int target, long value, int index) {
		if (target < s || e < target) {
			return;
		}
		if (s == e) {
			sumTree[index] = value;
			return;
		}
		int m = (s + e) / 2;
		update(s, m, target, value, 2 * index);
		update(m + 1, e, target, value, 2 * index + 1);
		sumTree[index] = sumTree[2 * index] + sumTree[2 * index + 1];
	}
}
