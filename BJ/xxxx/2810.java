import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2810 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int count = 0;
		boolean used = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'S') {
				count++;
			} else {
				if (!used) {
					count += 2;
					i++;
					used = true;
				} else {
					count++;
					i++;
				}
			}
		}
		System.out.println(count);
	}
}
