import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ28074 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Character> set = new HashSet<>();
		String S = br.readLine();
		for (int i = 0; i < S.length(); i++) {
			set.add(S.charAt(i));
		}
		boolean isPossible = true;
		if (!set.contains('M') || !set.contains('O') || !set.contains('B') || !set.contains('I')
				|| !set.contains('S')) {
			isPossible = false;
		}
		if (isPossible)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
