import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1439 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] count = new int[2];
		int last = s.charAt(0) - '0';
		count[last]++;
		for (int i = 1; i < s.length(); i++) {
			if (last != s.charAt(i) - '0') {
				last = s.charAt(i) - '0';
				count[last]++;
			}
		}
		System.out.println(Math.min(count[0], count[1]));
	}
}
