import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18429 {
	static int[] weight;
	static boolean[] done;
	static int N, K;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		count = 0;
		weight = new int[N];
		done = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(0, 500);
		System.out.println(count);
	}

	static void backtracking(int depth, int w) {
		if (depth == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (done[i])
				continue;
			if (w - K + weight[i] >= 500) {
				done[i] = true;
				backtracking(depth + 1, w - K + weight[i]);
				done[i] = false;
			}
		}
	}
}