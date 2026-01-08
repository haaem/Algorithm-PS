import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16508 {
	static int[] need = new int[26];
	static int[] count = new int[26];
	static String[] title;
	static int[] price;
	static int min;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		for (int i = 0; i < T.length(); i++) {
			need[T.charAt(i) - 'A']++;
		}
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		title = new String[N];
		price = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			price[i] = Integer.parseInt(st.nextToken());
			title[i] = st.nextToken();
		}
		min = Integer.MAX_VALUE;
		backTracking(0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void backTracking(int sum, int depth) {
		if (depth == N) {
			if (check()) {
				min = Math.min(min, sum);
			}
			return;
		}
		String t = title[depth];
		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i) - 'A']++;
		}
		backTracking(sum + price[depth], depth + 1);
		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i) - 'A']--;
		}
		backTracking(sum, depth + 1);
	}

	static boolean check() {
		for (int i = 0; i < 26; i++) {
			if (need[i] > count[i])
				return false;
		}
		return true;
	}
}
