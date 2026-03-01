import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1094 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		String binary = Integer.toBinaryString(X);
		int ans = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1')
				ans++;
		}
		System.out.println(ans);
	}
}
