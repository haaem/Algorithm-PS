import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1004 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(br.readLine());
			int res = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = (int) Math.sqrt(Math.pow(x1 - cx, 2) + Math.pow(y1 - cy, 2));
				int e = (int) Math.sqrt(Math.pow(x2 - cx, 2) + Math.pow(y2 - cy, 2));
				if (s < r ^ e < r) {
					res++;
				}
			}
			System.out.println(res);
		}
	}
}
