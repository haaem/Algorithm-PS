import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2343 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] blueray = new int[N];
		st = new StringTokenizer(br.readLine());
		long min = 0;
		long max = 0;
		for (int i = 0; i < N; i++) {
			blueray[i] = Integer.parseInt(st.nextToken());
			max += blueray[i];
			min = Math.max(min, blueray[i]);
		}
		while (min <= max) {
			long mid = (min + max) / 2;
			int sum = 0;
			int count = 0;
			for (int a = 0; a < N; a++) {
				if (sum + blueray[a] > mid) {
					sum = 0;
					count++;
				}
				sum += blueray[a];
			}
			if (sum != 0)
				count++;
			if (count <= M)
				max = mid - 1;
			else
				min = mid + 1;
		}
		System.out.println(min);
	}
}
