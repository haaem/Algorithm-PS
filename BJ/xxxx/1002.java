import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1002 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			if (x1 == x2 && y1 == y2) {
				if (r1 == r2)
					System.out.println(-1);
				else
					System.out.println(0);
			} else {
				int d = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
				int o = (int) Math.pow(r1 + r2, 2);
				int i = (int) Math.pow(r1 - r2, 2);
				if (d < o && i < d) {
					System.out.println(2);
				} else if (d == o || d == i) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		}
	}
}
