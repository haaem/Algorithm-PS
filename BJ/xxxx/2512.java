import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2512 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] budget = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = 0, right = -1;
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, budget[i]);
		}
		int M = Integer.parseInt(br.readLine());

		while (left <= right) {
			int mid = (left + right) / 2;
			long total = 0;
			for (int i = 0; i < N; i++) {
				if (budget[i] < mid)
					total += budget[i];
				else
					total += mid;
			}
			if (total <= M)
				left = mid + 1;
			else
				right = mid - 1;
		}

		System.out.println(right);
	}
}
