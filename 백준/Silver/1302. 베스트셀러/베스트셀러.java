import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int max = 0;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			map.putIfAbsent(s, 0);
			int c = map.get(s);
			map.put(s, c + 1);
			max = Math.max(max, c + 1);
		}

		String s = null;
		for (String key : map.keySet()) {
			if (map.get(key) == max && (s == null || key.compareTo(s) < 0)) {
				s = key;
			}
		}
		System.out.println(s);
	}
}
