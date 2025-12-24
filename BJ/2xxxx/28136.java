import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ28136 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int last = first;
		int count = 0;
		for (int i = 0; i < N - 1; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp <= last) {
				count++;
			}
			last = temp;
		}
		if (first <= last)
			count++;
		System.out.println(count);
	}
}
