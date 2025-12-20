import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ27446 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] page = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			page[Integer.parseInt(st.nextToken())] = true;
		}
		int last = 0;
		int res = 0;
		for (int i = 1; i <= N; i++) {
			if (page[i])
				continue;
			if (last == 0) {
				res += 7;
			} else {
				res += Math.min(7, (i - last) * 2);
			}
			last = i;
		}
		System.out.println(res);
	}
}
