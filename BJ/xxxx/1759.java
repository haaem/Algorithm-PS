import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1759 {
	static int L;
	static int C;
	static char[] input;
	static HashSet<Character> vowel;
	static char[] res;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[C];
		res = new char[L];
		sb = new StringBuilder();
		vowel = new HashSet<Character>();
		vowel.add('a');
		vowel.add('e');
		vowel.add('i');
		vowel.add('o');
		vowel.add('u');
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		combi(0, 0);
		System.out.println(sb);
	}

	static void combi(int depth, int start) {
		if (depth == L) {
			boolean contains = false;
			int count = 0;
			for (int i = 0; i < L; i++) {
				if (vowel.contains(res[i])) {
					contains = true;
				} else {
					count++;
				}
			}
			if (contains && count >= 2) {
				for (char a : res) {
					sb.append(a);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = start; i < C; i++) {
			res[depth] = input[i];
			combi(depth + 1, i + 1);
		}
	}
}
