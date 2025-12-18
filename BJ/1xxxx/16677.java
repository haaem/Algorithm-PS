import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16677 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String m = br.readLine();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String res = null;
		double max = 0;
		boolean nojam = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String w = st.nextToken();
			int g = Integer.parseInt(st.nextToken());
			int count = 0;
			int index = 0;
			for (int j = 0; j < w.length(); j++) {
				if (index < m.length() && m.charAt(index) == w.charAt(j)) {
					index++;
				} else {
					count++;
				}
			}
			if (index == m.length()) {
				nojam = false;
				if (max < (double) g / count) {
					max = (double) g / count;
					res = w;
				}
			}
		}
		if (nojam)
			System.out.println("No Jam");
		else
			System.out.println(res);
	}
}
