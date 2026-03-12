import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ30890 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int total = x * y;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= total; i++) {
			if (i % x == 0 && i % y == 0)
				sb.append("3");
			else if (i % x == 0)
				sb.append("2");
			else if (i % y == 0)
				sb.append("1");
		}
		System.out.println(sb);
	}
}
