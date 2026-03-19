import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4796 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int index = 1;
		while (L != 0 && P != 0 && V != 0) {
			int count = 0;
			count += V / P * L + Math.min(V % P, L);
			System.out.println("Case " + (index++) + ": " + count);
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
		}
	}
}
