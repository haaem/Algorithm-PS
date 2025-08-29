import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11505 {
	static long[] multArr;
	static int[] arr;
	static int N, M, K;
	static long MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		multArr = new long[4 * N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		init(0, N - 1, 1);
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				update(0, N - 1, b - 1, c, 1);
			} else if (a == 2) {
				sb.append(query(0, N - 1, b - 1, c - 1, 1)).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void init(int s, int e, int index) {
		if (s == e) {
			multArr[index] = arr[s];
			return;
		}
		int m = (s + e) / 2;
		init(s, m, 2 * index);
		init(m + 1, e, 2 * index + 1);
		multArr[index] = multArr[2 * index] * multArr[2 * index + 1] % MOD;
	}

	static long query(int s, int e, int qs, int qe, int index) {
		if (qs <= s && e <= qe) {
			return multArr[index];
		} else if (e < qs || qe < s) {
			return 1;
		} else {
			int m = (s + e) / 2;
			long a = query(s, m, qs, qe, 2 * index);
			long b = query(m + 1, e, qs, qe, 2 * index + 1);
			return a * b % MOD;
		}
	}

	static void update(int s, int e, int target, int value, int index) {
		if (s > target || e < target)
			return;
		if (s == e) {
			multArr[index] = value;
			return;
		}
		int m = (s + e) / 2;
		update(s, m, target, value, 2 * index);
		update(m + 1, e, target, value, 2 * index + 1);
		multArr[index] = multArr[2 * index] * multArr[2 * index + 1] % MOD;
	}
}
