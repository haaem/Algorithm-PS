import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ23809 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] k = { { 1, 0, 0, 0, 1 }, { 1, 0, 0, 1, -1 }, { 1, 1, 1, -1, -1 }, { 1, 0, 0, 1, -1 },
				{ 1, 0, 0, 0, 1 } };
		for (int i = 0; i < 5 * N; i++) {
			for (int j = 0; j < 5 * N; j++) {
				int a = i / N;
				int b = j / N;

				if (k[a][b] == 1)
					sb.append('@');
				else if (k[a][b] == 0)
					sb.append(' ');
				else
					continue;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
