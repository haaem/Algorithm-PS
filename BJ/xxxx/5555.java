import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ5555 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			String ring = br.readLine();
			int len = s.length();
			String temp = ring.substring(10 - len);
			ring = temp + ring;
			for (int j = 0; j < 10; j++) {
				if (ring.substring(j, j + len).equals(s)) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
