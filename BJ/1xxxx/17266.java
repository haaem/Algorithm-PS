import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17266 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] x = new int[M];
		for (int i = 0; i < M; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		int left = 1, right = N;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean cover = true;
			if (x[0] > mid)
				cover = false;
			int index = 0;
			while (cover && index < M - 1) {
				if (x[index] + mid < x[index + 1] - mid)
					cover = false;
				index++;
			}
			if (N - x[M - 1] > mid)
				cover = false;
			if (cover)
				right = mid - 1;
			else
				left = mid + 1;
		}
		System.out.println(left);
	}
}
