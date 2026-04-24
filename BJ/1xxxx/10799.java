import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10799 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int res = 0;
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				left++;
			else {
				left--;
				if (s.charAt(i - 1) == '(')
					res += left;
				else
					res++;
			}
		}
		System.out.println(res);
	}
}
