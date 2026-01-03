import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ7662 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				char func = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());
				if (func == 'I') {
					map.putIfAbsent(n, 0);
					map.put(n, map.get(n) + 1);
				} else { // func == 'D'
					if (map.size() == 0)
						continue;
					int key;
					if (n == 1) {
						key = map.floorKey(Integer.MAX_VALUE);
					} else {
						key = map.ceilingKey(Integer.MIN_VALUE);
					}
					int size = map.get(key);
					if (size > 1) {
						map.put(key, size - 1);
					} else {
						map.remove(key);
					}
				}
			}
			if (map.size() == 0)
				sb.append("EMPTY\n");
			else
				sb.append(map.floorKey(Integer.MAX_VALUE)).append(" ").append(map.ceilingKey(Integer.MIN_VALUE))
						.append("\n");
		}
		System.out.println(sb);
	}
}
