import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ4948 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			if (n == 1) {
				sb.append("1\n");
				continue;
			}
			int count = 0;
			loop: for (int i = n + 1; i < 2 * n; i++) {
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						continue loop;
					}
				}
				count++;
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
