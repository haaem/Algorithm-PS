import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ19592 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			double min = Integer.MAX_VALUE;
			for (int i = 0; i < N - 1; i++) {
				min = Math.min(min, ((double) X) / Integer.parseInt(st.nextToken()));
			}
			int speed = Integer.parseInt(st.nextToken());

			// 시간 제일 짧을 때 비교 필요 없음
			if (min > ((double) X) / speed) {
				sb.append("0\n");
				continue;
			}

			int left = 0;
			int right = Y;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (min > ((double) X - mid) / speed + 1) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			if (left > Y)
				sb.append("-1\n");
			else
				sb.append(left).append("\n");
		}
		System.out.println(sb);
	}
}
