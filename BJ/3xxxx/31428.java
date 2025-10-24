import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ31428 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		map.put('C', 0);
		map.put('S', 0);
		map.put('I', 0);
		map.put('A', 0);
		for (int i = 0; i < N; i++) {
			char c = st.nextToken().charAt(0);
			map.put(c, map.get(c) + 1);
		}
		System.out.println(map.get(br.readLine().charAt(0)));
	}
}
