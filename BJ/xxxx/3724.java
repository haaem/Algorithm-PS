import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ3724 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			BigInteger max = BigInteger.ONE;
			for (int i = 0; i < N; i++) {
				BigInteger val = BigInteger.valueOf(arr[i][0]);
				max = max.multiply(val);
			}
			int index = 1;

			for (int j = 1; j < M; j++) {
				BigInteger mult = BigInteger.ONE;
				for (int i = 0; i < N; i++) {
					BigInteger val = BigInteger.valueOf(arr[i][j]);
					mult = mult.multiply(val);
				}
				if (mult.compareTo(max) >= 0) {
					max = mult;
					index = j + 1;
				}
			}
			System.out.println(index);
		}
	}
}
