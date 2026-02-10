import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ8958 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String s;
		for (int tc = 0; tc < T; tc++) {
			s = br.readLine();
			int c = 1;
			int point = 0;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'O')
					point += c++;
				else
					c = 1;
			}
			System.out.println(point);
		}
	}
}
