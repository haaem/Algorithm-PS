import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long count = 0;
		int[] mod = new int[M];
		Arrays.fill(mod, 0);
		count = Integer.parseInt(st.nextToken());
		mod[(int) (count % M)]++;
		for (int i = 1; i < N; i++) {
			count += Integer.parseInt(st.nextToken());
			mod[(int) (count % M)]++;
		}
		long c = mod[0];
		for (int i = 0; i < M; i++) {
			long a = mod[i];
			c += a * (a - 1) / 2;
		}
		System.out.println(c);
	}
}
