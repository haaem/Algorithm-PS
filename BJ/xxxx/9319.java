import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9319 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int B = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			double[] r = new double[n + 1];
			double sum = 0;
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				int xi = Integer.parseInt(st.nextToken());
				int yi = Integer.parseInt(st.nextToken());
				int si = Integer.parseInt(st.nextToken());
				r[i] = si / (Math.pow(xi - x, 2) + Math.pow(yi - y, 2));
				sum += r[i];
			}

			int res = -1;
			for (int i = 1; i <= n; i++) {
				if (r[i] > 6 * (B + sum - r[i])) {
					res = i;
					break;
				}
			}
			if (res == -1) {
				System.out.println("NOISE");
			} else {
				System.out.println(res);
			}
		}
	}
}
