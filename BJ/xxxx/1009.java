import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1009 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			a %= 10;
			if (a == 0) {
				System.out.println(10);
				continue;
			} else if (a == 1 || a == 5 || a == 6) {
				System.out.println(a);
				continue;
			} else if (a == 2 || a == 3 || a == 7 || a == 8) {
				b %= 4;
			} else if (a == 4 || a == 9) {
				b %= 2;
			}
			if (b == 0)
				b = 4;
			int mult = 1;
			for (int i = 0; i < b; i++) {
				mult *= a;
				mult %= 10;
			}
			System.out.println(mult);
		}
	}
}

// 2 4 8 6
// 3 9 7 1
// 4 6
// 5
// 6
// 7 9 3 1
// 8 4 2 6
// 9 1
// 10