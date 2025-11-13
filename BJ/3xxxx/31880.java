import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ31880 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long P = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P += Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a != 0) {
				P *= a;
			}
		}
		System.out.println(P);
	}
}
