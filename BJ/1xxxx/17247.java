import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17247 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] x = new int[2];
		int[] y = new int[2];
		int count = 0;
		loop: for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					x[count] = j;
					y[count] = i;
					count++;
				}
				if (count == 2)
					break loop;
			}
		}
		System.out.println(Math.abs(x[0] - x[1]) + Math.abs(y[0] - y[1]));
	}
}
