import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20309 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a % 2 == i % 2)
				continue;
			System.out.println("NO");
			System.exit(0);
		}
		System.out.println("YES");
	}
}
