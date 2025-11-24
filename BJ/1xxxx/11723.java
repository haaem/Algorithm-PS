import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ11723 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String func = st.nextToken();
			switch (func) {
			case "add": {
				set.add(Integer.parseInt(st.nextToken()));
				break;
			}
			case "remove": {
				int a = Integer.parseInt(st.nextToken());
				if (set.contains(a)) {
					set.remove(a);
				}
				break;
			}
			case "check": {
				if (set.contains(Integer.parseInt(st.nextToken()))) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			}
			case "toggle": {
				int a = Integer.parseInt(st.nextToken());
				if (set.contains(a)) {
					set.remove(a);
				} else {
					set.add(a);
				}
				break;
			}
			case "all": {
				Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
				set = new HashSet<Integer>(Arrays.asList(arr));
				break;
			}
			case "empty": {
				set = new HashSet<>();
				break;
			}
			}
		}
		System.out.println(sb);
	}
}
