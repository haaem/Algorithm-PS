import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ23881 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		String res = "";
		loop: for (int i = N - 1; i >= 1; i--) {
			int max = 0, index = -1;
			for (int j = 0; j <= i; j++) {
				if (max < A[j]) {
					index = j;
					max = A[j];
				}
			}
			if (i != index) {
				count++;
				int temp = A[index];
				A[index] = A[i];
				A[i] = temp;
				if (count == K) {
					res = Math.min(A[i], A[index]) + " " + Math.max(A[i], A[index]);
					break loop;
				}
			}
		}
		if (count < K)
			System.out.println(-1);
		else
			System.out.println(res);
	}
}
