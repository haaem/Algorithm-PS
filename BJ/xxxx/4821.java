import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ4821 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t != 0) {
			String[] s = br.readLine().split(",");
			HashSet<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < s.length; i++) {
				if (s[i].contains("-")) {
					String[] temp = s[i].split("-");
					int low = Integer.parseInt(temp[0]);
					int high = Integer.parseInt(temp[1]);
					if (low <= high) {
						for (int j = low; j <= high && j <= t; j++) {
							set.add(j);
						}
					}
				} else {
					int temp = Integer.parseInt(s[i]);
					if (temp <= t)
						set.add(temp);
				}
			}
			sb.append(set.size()).append("\n");
			t = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
	}
}
