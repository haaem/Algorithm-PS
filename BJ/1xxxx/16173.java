import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16173 {
	static int[][] board;
	static boolean[][] visited;
	static int N;
	static boolean isPossible;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][N];
		backTracking(new int[] { 0, 0 });
		if (isPossible) {
			System.out.println("HaruHaru");
		} else {
			System.out.println("Hing");
		}
	}

	static void backTracking(int[] arr) {
		if (arr[0] == N - 1 && arr[1] == N - 1) {
			isPossible = true;
			return;
		}
		int ni = arr[0] + board[arr[0]][arr[1]];
		int nj = arr[1] + board[arr[0]][arr[1]];
		if (ni < N && !visited[ni][arr[1]]) {
			visited[ni][arr[1]] = true;
			backTracking(new int[] { ni, arr[1] });
			visited[ni][arr[1]] = false;
		}
		if (nj < N && !visited[arr[0]][nj]) {
			visited[arr[0]][nj] = true;
			backTracking(new int[] { arr[0], nj });
			visited[arr[0]][nj] = false;
		}
	}
}
