import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ24724 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			br.readLine();
			for (int a = 0; a < N; a++) {
				br.readLine();
			}
			System.out.println("Material Management " + tc);
			System.out.println("Classification ---- End!");
		}
	}
}
