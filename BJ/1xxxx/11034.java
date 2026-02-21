import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11034 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringTokenizer st;
		while ((s = br.readLine()) != null) {
			st = new StringTokenizer(s);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			System.out.println(Math.max(B - A, C - B) - 1);
		}
	}
}
