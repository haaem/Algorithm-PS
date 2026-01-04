import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16461 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			double temp = Double.parseDouble(st.nextToken()); // double로 계산 시 부동소수점 오차 발생
			int A = (int) Math.round(temp * 1000); // 연산자 우선 순위 주의 !
			temp = Double.parseDouble(st.nextToken());
			int B = (int) Math.round(temp * 1000);
			char cur = st.nextToken().charAt(0);
			temp = Double.parseDouble(st.nextToken());
			int target = (int) Math.round(temp * 1000);

			int var;
			if (cur == 'A') {
				if (target == A) {
					sb.append("0\n");
					continue;
				} else if (target == B) {
					sb.append("1\n");
					continue;
				}
			} else {// cur == 'B'
				if (target == B) {
					sb.append("0\n");
					continue;
				} else if (target == A) {
					sb.append("1\n");
					continue;
				}
			}

			// Number Button
			int min = 6;

			int count;
			// UP button
			var = A;
			if (cur == 'A') {
				count = 0;
			} else {
				count = 1;
			}
			while (var != target) {
				if (count > 6)
					break;
				var += 20;
				if (var > 146000) {
					var = 144000;
				}
				count++;
			}
			min = Math.min(min, count);

			var = B;
			if (cur == 'A') {
				count = 1;
			} else {
				count = 0;
			}
			while (var != target) {
				if (count > 6)
					break;
				var += 20;
				if (var > 146000) {
					var = 144000;
				}
				count++;
			}
			min = Math.min(min, count);

			// DOWN Button
			var = A;
			if (cur == 'A') {
				count = 0;
			} else {
				count = 1;
			}
			while (var != target) {
				if (count > 6)
					break;
				var -= 20;
				if (var < 144000) {
					var = 146000;
				}
				count++;
			}
			min = Math.min(min, count);

			var = B;
			if (cur == 'A') {
				count = 1;
			} else {
				count = 0;
			}
			while (var != target) {
				if (count > 6)
					break;
				var -= 20;
				if (var < 144000) {
					var = 146000;
				}
				count++;
			}
			min = Math.min(min, count);

			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
}
