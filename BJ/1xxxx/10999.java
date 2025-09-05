import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10999 {
	static int N, M, K;
	static long[] arr;
	static long[] tree;
	static long[] lazy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		tree = new long[4 * N];
		lazy = new long[4 * N];
		init(0, N - 1, 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			switch (a) {
			case 1: {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				update(0, N - 1, b - 1, c - 1, 1, d);
				break;
			}
			case 2: {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sb.append(query(0, N - 1, b - 1, c - 1, 1)).append("\n");
				break;
			}
			}
		}
		System.out.println(sb);
	}

	static long init(int s, int e, int index) {
		if (s == e)
			return tree[index] = arr[s];
		int mid = (s + e) / 2;
		return tree[index] = init(s, mid, 2 * index) + init(mid + 1, e, 2 * index + 1);
	}

	static void propagate(int s, int e, int index) {
		if (lazy[index] != 0) {
			if (s != e) {
				lazy[2 * index] += lazy[index];
				lazy[2 * index + 1] += lazy[index];
			}
			tree[index] += lazy[index] * (e - s + 1);
			lazy[index] = 0;
		}
	}

	static long query(int s, int e, int qs, int qe, int index) {
		propagate(s, e, index);
		if (e < qs || qe < s)
			return 0;
		if (qs <= s && e <= qe)
			return tree[index];
		int mid = (s + e) / 2;
		long a = query(s, mid, qs, qe, 2 * index);
		long b = query(mid + 1, e, qs, qe, 2 * index + 1);
		return a + b;
	}

	static void update(int s, int e, int qs, int qe, int index, long diff) {
		propagate(s, e, index);
		if (e < qs || qe < s)
			return;
		if (qs <= s && e <= qe) {
			tree[index] += diff * (e - s + 1);
			if (s != e) {
				lazy[2 * index] += diff;
				lazy[2 * index + 1] += diff;
			}
			return;
		}
		int mid = (s + e) / 2;
		update(s, mid, qs, qe, 2 * index, diff);
		update(mid + 1, e, qs, qe, 2 * index + 1, diff);
		tree[index] = tree[2 * index] + tree[2 * index + 1];
	}
}
