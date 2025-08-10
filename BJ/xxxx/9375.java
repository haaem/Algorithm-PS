import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ9375 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		HashMap<String, ArrayList<String>> map;
		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			map = new HashMap<String, ArrayList<String>>();
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				String clothes = st.nextToken();
				String kind = st.nextToken();
				map.computeIfAbsent(kind, k -> new ArrayList<String>()).add(clothes);
			}
			int count = 1;
			for (String key : map.keySet()) {
				count *= map.get(key).size() + 1;
			}
			System.out.println(count - 1);
		}
	}
}
