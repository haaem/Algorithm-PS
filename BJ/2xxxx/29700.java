import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ29700 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] theater = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				theater[i][j] = Integer.parseInt(s.substring(j, j + 1));
			}
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= M - K; j++) {
				for (int k = 0; k < K; k++) {
					if (theater[i][j + k] == 1)
						break;
					if (k == K - 1)
						count++;
				}
			}
		}
		System.out.println(count);
	}
}
