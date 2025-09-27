import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13305 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] road = new long[N - 1];
		for (int i = 0; i < N - 1; i++) {
			road[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		long[] price = new long[N];
		for (int i = 0; i < N; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}

		long sum = 0;
		long min = price[0];
		for (int i = 0; i < N - 1; i++) {
			min = Math.min(min, price[i]);
			sum += min * road[i];
		}

		System.out.println(sum);
	}
}
