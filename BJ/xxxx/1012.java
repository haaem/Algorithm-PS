import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1012 {
	static int[][] field;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int count;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			field = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				field[Y][X] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}

	public static void dfs(int i, int j) {
		for (int a = 0; a < 4; a++) {
			int x = j + dx[a];
			int y = i + dy[a];
			if (0 <= x && x < M && 0 <= y && y < N) {
				if (field[y][x] == 1) {
					field[y][x] = 0;
					dfs(y, x);
				}
			}
		}
	}
}
