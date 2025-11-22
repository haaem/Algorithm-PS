import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ28432 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			br.readLine(); // "?"
			br.readLine(); // M
			System.out.println(br.readLine());
			System.exit(0);
		}
		String[] S = new String[N];
		char start = '?';
		char end = '?';
		int index = -1;
		for (int i = 0; i < N; i++) {
			S[i] = br.readLine();
			if (S[i].equals("?")) {
				index = i;
			}
		}
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			if (i != index) {
				set.add(S[i]);
			}
		}
		if (index == 0) {
			end = S[1].charAt(0);
		} else if (index == N - 1) {
			start = S[N - 2].charAt(S[N - 2].length() - 1);
		} else {
			end = S[index + 1].charAt(0);
			start = S[index - 1].charAt(S[index - 1].length() - 1);
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String c = br.readLine();
			if (!set.contains(c)) {
				if (index == 0 && end == c.charAt(c.length() - 1)) {
					System.out.println(c);
					System.exit(0);
				} else if (index == N - 1 && start == c.charAt(0)) {
					System.out.println(c);
					System.exit(0);
				} else {
					if (end == c.charAt(c.length() - 1) && start == c.charAt(0)) {
						System.out.println(c);
						System.exit(0);
					}
				}
			}
		}
	}
}
