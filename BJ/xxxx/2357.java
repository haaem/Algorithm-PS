import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2357 {
	static int N, M;
	static long[] arr;
	static long[] minArr, maxArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new long[N];
		minArr = new long[4 * N];
		maxArr = new long[4 * N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(0, N - 1, 1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long[] temp = query(0, N - 1, a - 1, b - 1, 1);
			sb.append(temp[0]).append(" ").append(temp[1]).append("\n");
		}
		System.out.println(sb);
	}

	static void init(int s, int e, int index) {
		if (s == e) {
			minArr[index] = arr[s];
			maxArr[index] = arr[s];
			return;
		}
		int m = (s + e) / 2;
		init(s, m, 2 * index);
		init(m + 1, e, 2 * index + 1);
		minArr[index] = Math.min(minArr[2 * index], minArr[2 * index + 1]);
		maxArr[index] = Math.max(maxArr[2 * index], maxArr[2 * index + 1]);
	}

	static long[] query(int s, int e, int qs, int qe, int index) {
		if (e < qs || qe < s) {
			return new long[] { Long.MAX_VALUE, Long.MIN_VALUE };
		} else if (qs <= s && e <= qe) {
			return new long[] { minArr[index], maxArr[index] };
		} else {
			int m = (s + e) / 2;
			long[] a = query(s, m, qs, qe, 2 * index);
			long[] b = query(m + 1, e, qs, qe, 2 * index + 1);
			return new long[] { Math.min(a[0], b[0]), Math.max(a[1], b[1]) };
		}
	}
}
