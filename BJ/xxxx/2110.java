import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2110 {
	static int[] house;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);

		int lo = 1;
		int hi = house[N - 1] - house[0] + 1;

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (install(mid) < C)
				hi = mid;
			else
				lo = mid + 1;
		}

		System.out.println(lo - 1);
	}

	static int install(int dist) {
		int count = 1;
		int last = house[0];

		for (int i = 1; i < house.length; i++) {
			int cur = house[i];

			if (cur - last >= dist) {
				count++;
				last = cur;
			}
		}
		return count;
	}
}
