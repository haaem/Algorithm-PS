import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ4158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		while (N != 0 || M != 0) {
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < N; i++) {
				set.add(Integer.parseInt(br.readLine()));
			}
			int count = 0;
			for (int i = 0; i < M; i++) {
				if (set.contains(Integer.parseInt(br.readLine())))
					count++;
			}
			sb.append(count).append("\n");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
	}
}
