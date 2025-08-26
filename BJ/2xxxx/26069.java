import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ26069 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		HashSet<String> set = new HashSet<String>();
		set.add("ChongChong");
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			String B = st.nextToken();
			if (set.contains(A)) {
				set.add(B);
			} else if (set.contains(B)) {
				set.add(A);
			}
		}
		System.out.println(set.size());
	}
}
