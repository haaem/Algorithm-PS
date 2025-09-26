import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ1541 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		ArrayList<String> plus = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			plus.add(st.nextToken());
		}
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < plus.size(); i++) {
			st = new StringTokenizer(plus.get(i), "+");
			int sum = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
			}
			arr.add(sum);
		}
		int res = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			res -= arr.get(i);
		}
		System.out.println(res);
	}
}
