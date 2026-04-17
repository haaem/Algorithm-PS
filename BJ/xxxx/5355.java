import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5355 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			Float f = Float.parseFloat(st.nextToken());
			while (st.hasMoreTokens()) {
				char c = st.nextToken().charAt(0);
				switch (c) {
				case '@':
					f *= 3;
					break;
				case '%':
					f += 5;
					break;
				case '#':
					f -= 7;
					break;
				}
			}
			System.out.printf("%.2f\n", f);
		}
	}
}
