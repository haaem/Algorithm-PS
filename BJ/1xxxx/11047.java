import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11047 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		long count = 0;
		int index = N - 1;
		while (K > 0) {
			long a = K / A[index];
			count += a;
			K -= a * A[index--];
		}
		System.out.println(count);
	}
}
