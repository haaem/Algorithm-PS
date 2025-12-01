import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18111 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int min = 256;
		int max = 0;
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		int minTime = Integer.MAX_VALUE;
		int height = -1;

		for (int h = min; h <= max; h++) {
			int curTime = 0;

			int a = 0;
			int b = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (h > map[i][j]) {
						a += h - map[i][j];
					} else if (h < map[i][j]) {
						b += map[i][j] - h;
					}
				}
			}

			if (b + B >= a) {
				curTime = a + b * 2;

				if (minTime >= curTime) {
					height = h;
					minTime = curTime;
				}
			}
		}

		System.out.println(minTime + " " + height);
	}
}
