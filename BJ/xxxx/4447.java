import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ4447 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String S = br.readLine();
			int g = 0, b = 0;
			for (int j = 0; j < S.length(); j++) {
				char t = S.toLowerCase().charAt(j);
				if (t == 'g') {
					g++;
				} else if (t == 'b') {
					b++;
				}
			}
			if (g > b)
				System.out.println(S + " is GOOD");
			else if (b > g)
				System.out.println(S + " is A BADDY");
			else
				System.out.println(S + " is NEUTRAL");
		}
	}
}
