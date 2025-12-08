import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BJ11652 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
		for (int i = 0; i < N; i++) {
			long input = Long.parseLong(br.readLine());
			map.putIfAbsent(input, 0);
			map.put(input, map.get(input) + 1);
		}
		long max = Long.MIN_VALUE;
		long t = 0;
		for (long key : map.keySet()) {
			if (max < map.get(key)) {
				max = map.get(key);
				t = key;
			}
		}
		System.out.println(t);
	}
}
