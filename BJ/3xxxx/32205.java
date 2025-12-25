import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ32205 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				set.add(Integer.parseInt(st.nextToken()));
		}
		if (set.size() == N * 3) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}
	}
}
