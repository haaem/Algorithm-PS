import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ18248 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if (N == 1) {
			System.out.println("YES");
			return;
		}
		int[][] arr = new int[N][M + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
			}
			arr[i][M] = sum;
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[M] - o1[M];
			}
		});

		for (int j = 0; j < M; j++) {
			for (int i = 1; i < N; i++) {
				if (arr[i - 1][j] < arr[i][j]) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
	}
}
