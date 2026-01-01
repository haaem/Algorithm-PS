import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5556 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t1 = Math.min(a, Math.abs(N - a + 1));
			int t2 = Math.min(b, Math.abs(N - b + 1));
			int min = Math.min(t1, t2);
			switch (min % 3) {
			case 0: {
				sb.append("3\n");
				break;
			}
			case 1: {
				sb.append("1\n");
				break;
			}
			case 2: {
				sb.append("2\n");
				break;
			}
			}
		}
		System.out.println(sb);
	}
}
