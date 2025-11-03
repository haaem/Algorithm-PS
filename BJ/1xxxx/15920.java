import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ15920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		int cur = 1; // A
		boolean multi = false;
		boolean way = true; // 5명
		for (int i = 0; i < N; i++) {
			char c = S.charAt(i);
			if (c == 'W') {
				if (cur <= 2) {
					cur++;
				}
			} else if (c == 'P') {
				if (cur == 1) {
					way = !way;
				} else if (cur == 2) {
					multi = true;
				}
			}
			if (cur == 3) {
				if (multi) {
					System.out.println(6);
				} else {
					if (way)
						System.out.println(5);
					else
						System.out.println(1);
				}
				break;
			}
		}
		if (cur < 3)
			System.out.println(0);
	}
}
