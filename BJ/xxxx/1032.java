import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1032 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String res = br.readLine();
		for (int i = 0; i < N - 1; i++) {
			String next = br.readLine();
			for (int j = 0; j < next.length(); j++) {
				if (res.charAt(j) != '?' && res.charAt(j) != next.charAt(j)) {
					res = res.substring(0, j) + "?" + res.substring(j + 1);
				}
			}
		}
		System.out.println(res);
	}
}
