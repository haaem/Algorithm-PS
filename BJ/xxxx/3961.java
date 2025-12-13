import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ3961 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		HashMap<Character, int[]> map = new HashMap<Character, int[]>();
		map.put('q', new int[] { 1, 1 });
		map.put('w', new int[] { 1, 2 });
		map.put('e', new int[] { 1, 3 });
		map.put('r', new int[] { 1, 4 });
		map.put('t', new int[] { 1, 5 });
		map.put('y', new int[] { 1, 6 });
		map.put('u', new int[] { 1, 7 });
		map.put('i', new int[] { 1, 8 });
		map.put('o', new int[] { 1, 9 });
		map.put('p', new int[] { 1, 10 });
		map.put('a', new int[] { 2, 1 });
		map.put('s', new int[] { 2, 2 });
		map.put('d', new int[] { 2, 3 });
		map.put('f', new int[] { 2, 4 });
		map.put('g', new int[] { 2, 5 });
		map.put('h', new int[] { 2, 6 });
		map.put('j', new int[] { 2, 7 });
		map.put('k', new int[] { 2, 8 });
		map.put('l', new int[] { 2, 9 });
		map.put('z', new int[] { 3, 1 });
		map.put('x', new int[] { 3, 2 });
		map.put('c', new int[] { 3, 3 });
		map.put('v', new int[] { 3, 4 });
		map.put('b', new int[] { 3, 5 });
		map.put('n', new int[] { 3, 6 });
		map.put('m', new int[] { 3, 7 });

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int l = Integer.parseInt(st.nextToken());
			TreeMap<Integer, ArrayList<String>> m = new TreeMap();
			for (int i = 0; i < l; i++) {
				String input = br.readLine();
				int dis = 0;
				for (int j = 0; j < s.length(); j++) {
					char a = s.charAt(j);
					char b = input.charAt(j);
					dis += Math.abs(map.get(a)[0] - map.get(b)[0]) + Math.abs(map.get(a)[1] - map.get(b)[1]);
				}
				m.putIfAbsent(dis, new ArrayList<String>());
				m.get(dis).add(input);
			}
			for (int a : m.keySet()) {
				Collections.sort(m.get(a));
				for (String ans : m.get(a)) {
					sb.append(ans).append(" ").append(a).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
