import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17406 {
	static int N, M, K;
	static int[][] arr, origin;
	static int[][] order;
	static int[] temp;
	static int min;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		origin = new int[N + 1][M + 1];
		arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = origin[i][j];
			}
		}

		order = new int[K][3];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			order[k] = new int[] { r, c, s };
		}

		visited = new boolean[K];
		temp = new int[K];

		min = Integer.MAX_VALUE;
		permutation(0);
		System.out.println(min);
	}

	private static void permutation(int depth) {
		if (depth == K) {
			for (int i = 0; i < N + 1; i++) {
				arr[i] = Arrays.copyOf(origin[i], origin[i].length);
			}
			for (int i = 0; i < K; i++) {
				int[] o = order[temp[i]];
				rotate(o[0], o[1], o[2]);
			}
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += arr[i][j];
				}
				min = Math.min(min, sum);
			}
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[depth] = i;
				permutation(depth + 1);
				visited[i] = false;
			}
		}
	}

	private static void rotate(int r, int c, int s) {
		if (s == 0)
			return;
		int top = r - s;
		int left = c - s;
		int bottom = r + s;
		int right = c + s;

		int temp = arr[top][left];

		for (int i = top; i < bottom; i++) {
			arr[i][left] = arr[i + 1][left];
		}
		for (int i = left; i < right; i++) {
			arr[bottom][i] = arr[bottom][i + 1];
		}
		for (int i = bottom; i > top; i--) {
			arr[i][right] = arr[i - 1][right];
		}
		for (int i = right; i > left + 1; i--) {
			arr[top][i] = arr[top][i - 1];
		}

		arr[top][left + 1] = temp;

		rotate(r, c, s - 1);
	}
}
