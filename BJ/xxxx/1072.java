import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1072 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long now = Y * 100 / X; // %
		// X값도 늘어야함
		// 그럼 여기서 이분 탐색
		int l = 1;
		int r = 1000000000;
		int res = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			long next = (Y + mid) * 100 / (X + mid);
			if (next > now) {
				res = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(res);
	}
}
