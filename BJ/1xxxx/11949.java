import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11949 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (A[j] % i > A[j + 1] % i) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(A[i]);
		}
	}
}
