import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ1919 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			map1.putIfAbsent(c, 0);
			map1.put(c, map1.get(c) + 1);
		}
		for (int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if (map1.containsKey(c) && map1.get(c) > 0) {
				map1.put(c, map1.get(c) - 1);
			} else {
				map2.putIfAbsent(c, 0);
				map2.put(c, map2.get(c) + 1);
			}
		}
		int count = 0;
		for (char c : map1.keySet()) {
			count += map1.get(c);
		}
		for (char c : map2.keySet()) {
			count += map2.get(c);
		}
		System.out.println(count);
	}
}
