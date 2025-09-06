import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ11403 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] map = new int[N][N];
		int[][] ans = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (map[i][k] == 0)
					continue;
				ans[i][k] = 1;
				for (int j = 0; j < N; j++) {
					if (map[k][j] == 0)
						continue;
					map[i][j] = 1;
					ans[i][j] = 1;
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.append(ans[i][j] + " ");
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
	}
}
