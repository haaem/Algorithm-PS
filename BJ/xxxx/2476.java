import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2476 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == b && b == c)
				max = Math.max(max, b * 1000 + 10000);
			else if (a == b || b == c || a == c) {
				if (a == b) {
					max = Math.max(max, b * 100 + 1000);
				} else {
					max = Math.max(max, c * 100 + 1000);
				}
			} else {
				int temp = Math.max(a, Math.max(b, c));
				max = Math.max(max, temp * 100);
			}
		}
		System.out.println(max);
	}
}
