import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11721 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for (int i = 0; i < s.length() / 10; i++) {
			System.out.println(s.substring(i * 10, (i + 1) * 10));
		}
		if (s.length() % 10 != 0) {
			System.out.println(s.substring(10 * (s.length() / 10)));
		}
	}
}
