import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ27983 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		long[] X = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			X[i] = Long.parseLong(st.nextToken());
		}
		long[] L = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			L[i] = Long.parseLong(st.nextToken());
		}
		char[] C = new char[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			C[i] = st.nextToken().charAt(0);
		}

		boolean possible = false;
		int a = -1, b = -1;
		loop: for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (C[i] != C[j]) {
					if (Math.abs(X[i] - X[j]) <= L[i] + L[j]) {
						possible = true;
						a = i;
						b = j;
					}
				}
				if (possible)
					break loop;
			}
		}
		if (possible) {
			System.out.println("YES");
			System.out.println(a + " " + b);
		} else {
			System.out.println("NO");
		}
	}
}
