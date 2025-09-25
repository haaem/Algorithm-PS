import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ2565 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Wire[] arr = new Wire[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr, new Comparator<Wire>() {
			@Override
			public int compare(Wire o1, Wire o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j].end < arr[i].end) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(N - max);
	}
}

class Wire {
	int start, end;

	public Wire(int s, int e) {
		this.start = s;
		this.end = e;
	}
}