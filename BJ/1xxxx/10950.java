import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10950 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
		}
	}
}
